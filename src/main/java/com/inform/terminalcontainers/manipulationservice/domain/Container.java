package com.inform.terminalcontainers.manipulationservice.domain;

import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.transittype.ContainerTransitState;
import com.inform.terminalcontainers.manipulationservice.domain.location.Location;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.util.Pair;

import java.util.Set;
import java.util.UUID;

@Data
@Document
public class Container {

    @Id
    private final UUID uuid;
    private final Set<Pair<PackedItemsUnit,Integer>> productPackagesWithQuantities;
    private ContainerTransitState containerTransitState;
    private ContainerContentState containerContentState;
    private Location location;


    @Autowired
    public Container(UUID uuid, Set<Pair<PackedItemsUnit,Integer>>  productPackagesWithQuantities) {
        this.containerTransitState = ContainerTransitState.WAITING_IN_CARRIER;//TODO Extend model, could be somewhere in the terminal area and not yet in the system
        this.containerContentState = ContainerContentState.LOADED;//TODO Extend model, could be in whatever content state, somewhere in the terminal area and not yet in the system

        this.uuid = uuid;
        this.productPackagesWithQuantities = productPackagesWithQuantities;
    }

    public Set<Pair<PackedItemsUnit, Integer>> getProductPackagesWithQuantities() {
        return productPackagesWithQuantities;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ContainerTransitState getContainerTransitState() {
        return containerTransitState;
    }

    public void setContainerTransitState(ContainerTransitState containerTransitState) {
        this.containerTransitState = containerTransitState;
    }

    public ContainerContentState getContainerContentState() {
        return containerContentState;
    }

    public void setContainerContentState(ContainerContentState containerContentState) {
        this.containerContentState = containerContentState;
    }

    public UUID getUuid() {//TODO Delete after Lombok's annotation processing starts working!
        return this.uuid;
    }
}
