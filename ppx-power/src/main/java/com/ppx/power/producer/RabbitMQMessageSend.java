package com.ppx.power.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RabbitMQMessageSend {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String message, String routeKey, String name) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(name,routeKey, message,correlationData);
    }
}
