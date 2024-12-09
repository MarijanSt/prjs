package com.inform.terminalcontainers.manipulationservice.domain.service;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.ContainerMessagePublisher;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.format.ContainerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContainerDomainMessageService implements ContainerMessageService {

    private final ContainerMessagePublisher messagePublisher;

    @Autowired
    public ContainerDomainMessageService(ContainerMessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void fireContainerEvent(ContainerMessage message, Container container) {
        messagePublisher.publish(message,container);
    }
}
