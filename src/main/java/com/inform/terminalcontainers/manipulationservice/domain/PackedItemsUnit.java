package com.inform.terminalcontainers.manipulationservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class PackedItemsUnit {
    private final Product product;
    private final Integer quantity;

    public PackedItemsUnit(@JsonProperty("product") final Product product, @JsonProperty("quantity") final Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
