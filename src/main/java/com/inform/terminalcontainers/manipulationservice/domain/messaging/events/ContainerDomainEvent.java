package com.inform.terminalcontainers.manipulationservice.domain.messaging.events;

import com.inform.terminalcontainers.manipulationservice.domain.location.Location;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ContainerDomainEvent {
    protected final LocalDateTime time;
    protected final UUID containerId;
    protected final Location location;

    //TODO How the event would be serialised, to JSON? Then you must add some annotations: i.e. @JsonProperty!

    protected ContainerDomainEvent(LocalDateTime time, UUID containerId, Location location) {
        this.time = time;
        this.containerId = containerId;
        this.location = location;
    }
}
