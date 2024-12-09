package com.inform.terminalcontainers.manipulationservice.domain.exception;

import com.inform.terminalcontainers.manipulationservice.domain.location.StackingDockingLocation;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.FixedLocationType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ContainerAlreadyEmptiedException extends ContainerContentLoadUnloadException {

    public ContainerAlreadyEmptiedException(StackingDockingLocation fixedLocation, UUID containerId) {
        super(fixedLocation, containerId);
    }

    public ContainerAlreadyEmptiedException(int xCoordinateInAreaMatrix, int yCoordinateInAreaMatrix,
                                            int zCoordinateInAreaMatrix, FixedLocationType locationType,
                                            UUID containerId) {
        super(new StackingDockingLocation(xCoordinateInAreaMatrix, yCoordinateInAreaMatrix,
                zCoordinateInAreaMatrix, locationType), containerId);
    }
}
