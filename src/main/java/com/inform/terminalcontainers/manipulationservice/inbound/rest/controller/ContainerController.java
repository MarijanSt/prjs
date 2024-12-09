package com.inform.terminalcontainers.manipulationservice.inbound.rest.controller;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.service.ContainerService;
import com.inform.terminalcontainers.manipulationservice.inbound.rest.request.CreateContainerRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/containers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ContainerController {

    private final ContainerService containerService;

    @Autowired
    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Container> getContainerByItsId(@PathVariable("id") UUID uuid) {
        Optional<Container> optionalContainer = containerService.findContainerById(uuid);
        return optionalContainer.map(container ->
                new ResponseEntity<>(container, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Container> createContainer(@RequestBody final CreateContainerRequestBody requestBody) {

        Container container = new Container(UUID.randomUUID(), requestBody.getProductPackagesWithQuantities());
        containerService.createAndSaveTheContainer(container);

        return new ResponseEntity<>(container, HttpStatus.CREATED);
    }

    //TODO Add endpoints...
}
