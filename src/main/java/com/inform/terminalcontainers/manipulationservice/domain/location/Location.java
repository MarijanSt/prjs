package com.inform.terminalcontainers.manipulationservice.domain.location;

import com.inform.terminalcontainers.manipulationservice.domain.location.type.LocationType;

/**
 * Can be of type fixed (x,y,z) acc. to the semantic matrix of the loading/unloading area
 * or in-transit GPS (latitude, longitude)
 */
public interface Location {

    LocationType getLocationType();
}
