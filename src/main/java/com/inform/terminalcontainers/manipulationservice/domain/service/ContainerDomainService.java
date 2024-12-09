package com.inform.terminalcontainers.manipulationservice.domain.service;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.exception.ContainerException;
import com.inform.terminalcontainers.manipulationservice.domain.location.StackingDockingLocation;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.FixedLocationType;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.format.ContainerMessage;
import com.inform.terminalcontainers.manipulationservice.domain.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class ContainerDomainService implements ContainerService, ContainerMessageService {

    private final ContainerRepository repository;
    private final ContainerMessageService messageService;

    @Autowired
    public ContainerDomainService(ContainerRepository repository, ContainerMessageService messageService) {
        this.repository = repository;
        this.messageService = messageService;
    }

    @Override
    public void unloadContainerContentAtLocation(int xStorageMatrixCoordinate, int yStorageMatrixCoordinate,
                                                 int zStorageMatrixCoordinate, UUID uuid) {

        Optional<Container> optionalContainer = findContainerById(uuid);

        if(optionalContainer.isPresent()) {
            Container cont = optionalContainer.get();
            cont.setContainerContentState(ContainerContentState.BEING_EMPTIED);
            cont.setLocation(new StackingDockingLocation(xStorageMatrixCoordinate,
                    yStorageMatrixCoordinate, zStorageMatrixCoordinate, FixedLocationType.DOCKING_AREA));
            updateContainer(cont);
            fireContainerEvent(null, cont);

        } else {
            throw new ContainerException("No container present with UUID: " + uuid);
        }

    }

    @Override
    public Optional<Container> findContainerById(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public List<Container> findAllContainersInTransit() {
        return repository.findAllContainersStillInTransit();
    }

    @Override
    public List<Container> findAllWaitingContainers() {
        return repository.findAllContainersNotYetUnloadedFromCarrier();
    }

    @Override
    public List<Container> findAllContainersPlacedAtFinalDestination() {
        return repository.findAllContainersPlacedAtTheFinalDestination();
    }

    @Override
    public List<Container> findAllEmptyContainers() {
        return repository.findAllEmptyContainers();
    }

    @Override
    public List<Container> findAllFilledContainers() {
        return repository.findAllFilledContainers();
    }

    @Override
    public Container updateContainer(Container container) {
        return repository.update(container);
    }

    @Override
    public void createAndSaveTheContainer(Container container) { repository.save(container); }

    @Override
    public void batchCreateAndSaveContainers(Set<Container> containers) { repository.saveAll(containers); }

    @Override
    public void fireContainerEvent(ContainerMessage message, Container container) {
        messageService.fireContainerEvent(message, container);
    }
}
