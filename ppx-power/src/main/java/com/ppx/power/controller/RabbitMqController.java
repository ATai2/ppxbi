package com.ppx.power.controller;

import com.ppx.core.R;
import com.ppx.power.producer.RabbitMQMessageSend;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "mq")
@RestController
public class RabbitMqController {
    @Autowired
    RabbitMQMessageSend rabbitMQMessageSend;

    @GetMapping("/order.do")
    public R order(String message, String routeKey, String name) {
        rabbitMQMessageSend.sendMessage(message,"directExchange", "direct.key");
        return R.success("order ok");
    }

    @GetMapping("/ordererr.do")
    public R ordererr(String message, String routeKey, String name) {
        rabbitMQMessageSend.sendMessage(message, routeKey, name);
        return R.success("order ok");
    }
}
