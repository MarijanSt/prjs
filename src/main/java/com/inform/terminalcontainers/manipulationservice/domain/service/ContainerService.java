package com.inform.terminalcontainers.manipulationservice.domain.service;

import com.inform.terminalcontainers.manipulationservice.domain.Container;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ContainerService {


    /**
     * Called by a client like Automatic unloading/loading/transport vehicle/equipment, an operator doing manually-controlled
     * loading/unloading via an HMI or a mobile client, once container content has been completely unloaded
     */
    void unloadContainerContentAtLocation(int xStorageMatrixCoordinate, int yStorageMatrixCoordinate,
                                          int zStorageMatrixCoordinate, UUID uuid);

    Optional<Container> findContainerById(UUID uuid);

    /* Find different categories of containers */

    List<Container> findAllContainersInTransit();

    List<Container> findAllWaitingContainers();

    List<Container> findAllContainersPlacedAtFinalDestination();

    List<Container> findAllEmptyContainers();

    List<Container> findAllFilledContainers();

    /* Updating Container position/content */

    Container updateContainer(Container container);

    /* Single&Batch container creation */

    void createAndSaveTheContainer(Container container);

    void batchCreateAndSaveContainers(Set<Container> containers);
}
