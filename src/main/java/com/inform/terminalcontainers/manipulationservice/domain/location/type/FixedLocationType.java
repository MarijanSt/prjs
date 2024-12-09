package com.inform.terminalcontainers.manipulationservice.domain.location.type;

/**
 * Stacking area is where containers wait transportation to Docking area/Carriers or are simply temporarily
 * disposed there
 * Carrier is reserved for the Maritime carrier i.e. ship, tanker, etc.
 * Docking area is reserved for Distribution/Warehouse/Logistics center
 * Port hinterland may not be taken care of at all...
 */
public enum FixedLocationType implements LocationType {
    CARRIER, PORT_HINTERLAND, STACKING_AREA, DOCKING_AREA;

    private static final String LOCATION_TYPE = "FIXED";

    @Override
    public String getMainGroupLocationType() {
        return LOCATION_TYPE;
    }
}
