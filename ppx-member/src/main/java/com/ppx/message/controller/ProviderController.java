package com.ppx.message.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@Slf4j
@RestController
public class ProviderController {
    @Autowired
    private Queue queue;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("send")
    public void send(String name) {
        jmsMessagingTemplate.convertAndSend(queue, name);
    }

//    @JmsListener(destination="test")
//    public void readActiveQueue(String message) {
//        log.info("接受到：" + message);
//        //TODO something
//    }

}
