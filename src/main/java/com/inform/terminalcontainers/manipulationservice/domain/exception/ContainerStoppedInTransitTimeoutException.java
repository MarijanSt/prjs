package com.inform.terminalcontainers.manipulationservice.domain.exception;

import com.inform.terminalcontainers.manipulationservice.domain.location.InTransitLocation;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.TransitLocationType;
import lombok.Getter;

import java.time.Duration;
import java.util.UUID;

@Getter
public class ContainerStoppedInTransitTimeoutException extends ContainerException {

    private static final String EXCEPTION_MSG = "Container in transit is stopped for too long: Timeout exception!";

    private final InTransitLocation transitLocation;
    private final UUID containerId;
    private final Duration duration;

    public ContainerStoppedInTransitTimeoutException(InTransitLocation transitLocation, UUID containerId, Duration duration) {
        super(EXCEPTION_MSG);
        this.transitLocation = transitLocation;
        this.containerId = containerId;
        this.duration = duration;
    }

    public ContainerStoppedInTransitTimeoutException(double gPsLatitude, double gPsLongitude,
                                                     TransitLocationType locationType, UUID containerId, Duration duration) {
        this(new InTransitLocation(gPsLatitude, gPsLongitude, locationType), containerId, duration);
    }
}
