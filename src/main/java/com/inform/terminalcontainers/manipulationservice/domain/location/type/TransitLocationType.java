package com.inform.terminalcontainers.manipulationservice.domain.location.type;

/**
 * Models location for Container-in-transit to its final/temp location
 */
public enum TransitLocationType implements LocationType {
    TERMINAL_AREA, DISTRIBUTION_AREA, PORT_HINTERLAND_RECEPTION_AREA;

    private static final String LOCATION_TYPE = "TRANSIT";

    @Override
    public String getMainGroupLocationType() {
        return LOCATION_TYPE;
    }
}
