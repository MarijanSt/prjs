package com.inform.terminalcontainers.manipulationservice.domain.repository;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.transittype.ContainerTransitState;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ContainerRepository {

    Optional<Container> findById(UUID uuid);

    void save(Container container);

    void saveAll(Set<Container> containers);

    Container update(Container container);

    void delete(Container container);

    List<Container> findByContainerContentState(ContainerContentState containerContentState);

    List<Container> findAllEmptyContainers();

    List<Container> findAllFilledContainers();

    List<Container> findAllContainersBeingEmptied();

    List<Container> findAllContainersBeingFilled();

    List<Container> findByContainerTransitState(ContainerTransitState containerTransitState);

    List<Container> findAllContainersNotYetUnloadedFromCarrier();

    List<Container> findAllContainersPlacedAtTheFinalDestination();

    List<Container> findAllContainersStillInTransit();

    List<Container> findAllStoppedContainers();
}
