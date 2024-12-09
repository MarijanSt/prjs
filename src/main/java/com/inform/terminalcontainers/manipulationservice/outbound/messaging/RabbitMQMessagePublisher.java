package com.inform.terminalcontainers.manipulationservice.outbound.messaging;

import com.inform.terminalcontainers.manipulationservice.domain.Container;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.ContainerMessagePublisher;
import com.inform.terminalcontainers.manipulationservice.domain.messaging.format.ContainerMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessagePublisher implements ContainerMessagePublisher {

    private static final String EMPTY = "";
    private static final String FIXED_LOCATION_TYPE = "FIXED";
    private static final String TRANSIT_LOCATION_TYPE = "TRANSIT";

    private final RabbitTemplate rabbitTemplate;

    /* All recipients receive all messages, NO SPECIFIC routing depending on where the specific container is,
    its content, the functional area */
    @Value("${rabbitmq.exchange_name}")
    private String exchangeName;

    @Value("${rabbitmq.routing_key}")
    private String routingKey;

    /* Specify routing keys to intended recipients depending on where the specific container is, its content, the functional area */
    @Value("${rabbitmq.routing_key.automated_vehicles}")
    private String routingKeyForAutomatedVehicles;

    @Value("${rabbitmq.routing_key.stacking_area_manager}")
    private String routingKeyForStackingAreaManager;

    @Value("${rabbitmq.routing_key.cargo_terminal}")
    private String routingKeyForCargoTerminal;

    @Value("${rabbitmq.routing_key.distribution_and_logistics}")
    private String routingKeyForDistributionAndLogistics;

    @Autowired
    public RabbitMQMessagePublisher(final RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(ContainerMessage message, Container container) {

        /* TODO Depending on routing keys different recipients could be 'informed' */
        /*
        rabbitTemplate.convertAndSend(exchangeName, routingKeyForAutomatedVehicles, message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyForStackingAreaManager, message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyForCargoTerminal, message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyForDistributionAndLogistics, message);

         */

        MessageConverter converter = rabbitTemplate.getMessageConverter();
        MessageProperties properties = new MessageProperties();
        Message msg = converter.toMessage(container, properties);
        rabbitTemplate.send(exchangeName, routingKey, msg);
    }
}
