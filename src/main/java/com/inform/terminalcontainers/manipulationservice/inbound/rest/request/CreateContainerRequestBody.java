package com.inform.terminalcontainers.manipulationservice.inbound.rest.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inform.terminalcontainers.manipulationservice.domain.PackedItemsUnit;
import lombok.Getter;
import org.springframework.data.util.Pair;

import java.util.Set;

//@Getter
public class CreateContainerRequestBody {
    //@NotNull
    private final Set<Pair<PackedItemsUnit,Integer>> productPackagesWithQuantities;

    @JsonCreator
    public CreateContainerRequestBody(@JsonProperty("productPackagesWithQuantities")
                                          final Set<Pair<PackedItemsUnit,Integer>> productPackagesWithQuantities) {
        this.productPackagesWithQuantities = productPackagesWithQuantities;
    }

    public Set<Pair<PackedItemsUnit, Integer>> getProductPackagesWithQuantities() {
        return productPackagesWithQuantities;
    }
}
