package com.inform.terminalcontainers.manipulationservice.domain.exception;

import com.inform.terminalcontainers.manipulationservice.domain.location.StackingDockingLocation;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.FixedLocationType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ContainerLotOccupiedException extends ContainerException {

    private static final String EXCEPTION_MSG = "Container lot (placement position) is already occupied!";

    private final StackingDockingLocation fixedLocation;
    private final UUID containerId;

    public ContainerLotOccupiedException(StackingDockingLocation fixedLocation, UUID containerId) {
        super(EXCEPTION_MSG);
        this.fixedLocation = fixedLocation;
        this.containerId = containerId;
    }

    public ContainerLotOccupiedException(int xCoordinateInAreaMatrix, int yCoordinateInAreaMatrix,
                                         int zCoordinateInAreaMatrix, FixedLocationType locationType, UUID containerId) {
        this(new StackingDockingLocation(xCoordinateInAreaMatrix, yCoordinateInAreaMatrix,
                zCoordinateInAreaMatrix, locationType), containerId);
    }
}
