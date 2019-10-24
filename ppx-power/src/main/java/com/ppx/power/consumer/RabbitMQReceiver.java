package com.ppx.power.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {


    @RabbitListener(queues = "queue")
    public void get(String msg) {
        System.out.println(msg);
    }

}
