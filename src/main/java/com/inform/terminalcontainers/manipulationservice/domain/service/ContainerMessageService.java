package com.inform.terminalcontainers.manipulationservice.domain.service;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.format.ContainerMessage;

public interface ContainerMessageService {
    void fireContainerEvent(ContainerMessage message, Container container);
}
