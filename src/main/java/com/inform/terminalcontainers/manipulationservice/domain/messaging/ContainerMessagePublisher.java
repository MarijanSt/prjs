package com.inform.terminalcontainers.manipulationservice.domain.messaging;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.format.ContainerMessage;

public interface ContainerMessagePublisher {
    void publish(ContainerMessage message, Container container);
}
