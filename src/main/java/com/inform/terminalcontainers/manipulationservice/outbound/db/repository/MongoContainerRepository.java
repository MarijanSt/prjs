package com.inform.terminalcontainers.manipulationservice.outbound.db.repository;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.transittype.ContainerTransitState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MongoContainerRepository extends MongoRepository<Container, UUID> {
    Container findByUuid(UUID uuid);
    List<Container> findByContainerContentState(ContainerContentState containerContentState);
    List<Container> findByContainerTransitState(ContainerTransitState containerTransitState);
}
