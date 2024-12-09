package com.inform.terminalcontainers.manipulationservice.domain.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inform.terminalcontainers.manipulationservice.domain.location.type.LocationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models location in transit (GPS coordinates)
 */
@Data
public class InTransitLocation implements Location {
    private final double latitude;
    private final double longitude;
    private final LocationType locationType;

    public InTransitLocation(@JsonProperty("GPSLatitude") final double latitude,
                             @JsonProperty("GPSLongitude") final double longitude,
                             @JsonProperty("LocationType") LocationType locationType) {
        this.latitude = latitude;
        this.longitude = longitude;
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
