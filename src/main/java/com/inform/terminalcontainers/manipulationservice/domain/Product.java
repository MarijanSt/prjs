package com.inform.terminalcontainers.manipulationservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record Product(UUID productId, String name) {
    @JsonCreator
    public Product(@JsonProperty("productId") final UUID productId, @JsonProperty("name") final String name) {
        this.productId = productId;
        this.name = name;
    }
}
