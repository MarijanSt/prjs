package com.inform.terminalcontainers.manipulationservice.domain.exception;

import com.inform.terminalcontainers.manipulationservice.domain.location.StackingDockingLocation;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.FixedLocationType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ContainerAlreadyFilledException extends ContainerContentLoadUnloadException {

    public ContainerAlreadyFilledException(StackingDockingLocation fixedLocation, UUID containerId) {
        super(fixedLocation, containerId);
    }

    public ContainerAlreadyFilledException(int xCoordinateInAreaMatrix, int yCoordinateInAreaMatrix,
                                           int zCoordinateInAreaMatrix, FixedLocationType locationType,
                                           UUID containerId) {
        super(new StackingDockingLocation(xCoordinateInAreaMatrix, yCoordinateInAreaMatrix,
                zCoordinateInAreaMatrix, locationType), containerId);
    }
}
