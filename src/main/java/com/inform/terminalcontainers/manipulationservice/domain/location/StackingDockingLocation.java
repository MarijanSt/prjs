package com.inform.terminalcontainers.manipulationservice.domain.location;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.LocationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Container can be stacked/kept (placed) at, or moved (and temporarily be) to, some location in the
 * port storage/transit area
 */
@Getter
@EqualsAndHashCode
public class StackingDockingLocation implements Location {

    private final int xCoordinateInPortStorageMatrix;
    private final int yCoordinateInPortStorageMatrix;
    private final int zCoordinateInPortStorageMatrix;

    private final LocationType locationType;

    /**
     * Convenient for graphic display on Operator's HMI/SCADA, hand-held devices, web apps
     * Location
     * @param xCoordinateInPortStorageMatrix x coordinate is semantic and based on the predefined Matrix for the Port/Terminal area
     * @param yCoordinateInPortStorageMatrix y coordinate is semantic and based on the predefined Matrix for the Port/Terminal area
     * @param zCoordinateInPortStorageMatrix z coordinate is semantic and based on the predefined Matrix for the Port/Terminal area
     * @param locationType fixed (x,y,x) coordinates/in-transit GPS (longitude,latitude) coordinates
     */
    public StackingDockingLocation(@JsonProperty("xStorageMatrixCoordinate") final int xCoordinateInPortStorageMatrix,
                                   @JsonProperty("yStorageMatrixCoordinate") final int yCoordinateInPortStorageMatrix,
                                   @JsonProperty("zStorageMatrixCoordinate") final int zCoordinateInPortStorageMatrix,
                                   @JsonProperty("locationType") final LocationType locationType) {
        this.xCoordinateInPortStorageMatrix = xCoordinateInPortStorageMatrix;
        this.yCoordinateInPortStorageMatrix = yCoordinateInPortStorageMatrix;
        this.zCoordinateInPortStorageMatrix = zCoordinateInPortStorageMatrix;
        this.locationType = locationType;
    }

    //TODO Start doesn't work from within IntelliJ- Annotation processing for Lombok might not work!
    //TODO This method could be obsolete- From CLI all works fine!

    @Override
    public LocationType getLocationType() {
        return this.locationType;
    }
    /*
     */
}
