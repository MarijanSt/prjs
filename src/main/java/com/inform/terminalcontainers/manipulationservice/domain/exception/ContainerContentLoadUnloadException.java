package com.inform.terminalcontainers.manipulationservice.domain.exception;

import com.inform.terminalcontainers.manipulationservice.domain.location.StackingDockingLocation;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.FixedLocationType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ContainerContentLoadUnloadException extends ContainerException {

    protected static final String EXCEPTION_MSG = "Container is already emptied/filled!";

    protected final StackingDockingLocation fixedLocation;
    protected final UUID containerId;

    public ContainerContentLoadUnloadException(StackingDockingLocation fixedLocation, UUID containerId) {
        super(EXCEPTION_MSG);
        this.fixedLocation = fixedLocation;
        this.containerId = containerId;
    }

    public ContainerContentLoadUnloadException(int xCoordinateInAreaMatrix, int yCoordinateInAreaMatrix,
                                               int zCoordinateInAreaMatrix, FixedLocationType locationType,
                                               UUID containerId) {
        this(new StackingDockingLocation(xCoordinateInAreaMatrix, yCoordinateInAreaMatrix,
                zCoordinateInAreaMatrix, locationType), containerId);
    }
}
