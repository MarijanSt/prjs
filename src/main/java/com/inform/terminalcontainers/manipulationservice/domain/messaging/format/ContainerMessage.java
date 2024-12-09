package com.inform.terminalcontainers.manipulationservice.domain.messaging.format;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.contenttype.ContainerContentState;
import com.inform.terminalcontainers.manipulationservice.domain.containerstate.transittype.ContainerTransitState;
import com.inform.terminalcontainers.manipulationservice.domain.location.Location;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record ContainerMessage(@JsonProperty("eventDateAndTime") LocalDateTime time,
                               @JsonProperty("containerId") UUID containerId,
                               @JsonProperty("location") Location eventLocation,
                               @JsonProperty("containerContentState") ContainerContentState contentState,
                               @JsonProperty("containerTransitState")ContainerTransitState transitState)
        implements Serializable {
}
