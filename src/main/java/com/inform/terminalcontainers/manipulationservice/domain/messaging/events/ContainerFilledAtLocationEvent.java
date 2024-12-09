package com.inform.terminalcontainers.manipulationservice.domain.messaging.events;

import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.transittype.ContainerTransitState;
import com.inform.terminalcontainers.manipulationservice.domain.location.Location;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ContainerFilledAtLocationEvent extends ContainerDomainEvent {

    private final ContainerTransitState transitState;
    private final ContainerContentState contentState;
    private final Location location;

    public ContainerFilledAtLocationEvent(LocalDateTime time, UUID containerId, ContainerTransitState transitState,
                                          Location location) {
        super(time, containerId, location);
        this.transitState = transitState;
        this.contentState = ContainerContentState.LOADED;
        this.location = location;
    }
}
