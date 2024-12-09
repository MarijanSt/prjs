package com.inform.terminalcontainers.manipulationservice.outbound.db.repository;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.transittype.ContainerTransitState;
import com.inform.terminalcontainers.manipulationservice.domain.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class MongoDbContainerRepository implements ContainerRepository {

    private final MongoContainerRepository dbRepository;

    @Autowired
    public MongoDbContainerRepository(MongoContainerRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Container> findById(UUID uuid) {
        return dbRepository.findById(uuid);
    }

    @Override
    public void save(Container container) {
        dbRepository.save(container);
    }

    @Override
    public void saveAll(Set<Container> containers) {
        dbRepository.saveAll(containers);
    }

    @Override
    public Container update(Container container) {
        Optional<Container> optionalContainer = dbRepository.findById(container.getUuid());
        if (optionalContainer.isPresent()) {
            Container cont = optionalContainer.get();
            dbRepository.save(cont);
            return cont;
        }
        return null;
    }

    @Override
    public void delete(Container container) {
        dbRepository.delete(container);
    }

    @Override
    public List<Container> findByContainerContentState(ContainerContentState containerContentState) {
        return dbRepository.findByContainerContentState(containerContentState);
    }

    @Override
    public List<Container> findAllEmptyContainers() {
        return dbRepository.findByContainerContentState(ContainerContentState.EMPTIED);
    }

    @Override
    public List<Container> findAllFilledContainers() {
        return dbRepository.findByContainerContentState(ContainerContentState.LOADED);
    }

    @Override
    public List<Container> findAllContainersBeingEmptied() {
        return dbRepository.findByContainerContentState(ContainerContentState.BEING_EMPTIED);
    }

    @Override
    public List<Container> findAllContainersBeingFilled() {
        return dbRepository.findByContainerContentState(ContainerContentState.BEING_LOADED);
    }

    @Override
    public List<Container> findByContainerTransitState(ContainerTransitState containerTransitState) {
        return dbRepository.findByContainerTransitState(containerTransitState);
    }

    @Override
    public List<Container> findAllContainersNotYetUnloadedFromCarrier() {
        return dbRepository.findByContainerTransitState(ContainerTransitState.WAITING_IN_CARRIER);
    }

    @Override
    public List<Container> findAllContainersPlacedAtTheFinalDestination() {
        return dbRepository.findByContainerTransitState(ContainerTransitState.ARRIVED_AT_FINAL_DESTINATION);
    }

    @Override
    public List<Container> findAllContainersStillInTransit() {
        return dbRepository.findByContainerTransitState(ContainerTransitState.MOVING);
    }

    @Override
    public List<Container> findAllStoppedContainers() {
        return dbRepository.findByContainerTransitState(ContainerTransitState.STOPPED);
    }
}
