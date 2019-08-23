package com.ppx.config;

import com.ppx.api.base.Constants;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@Configuration
public class BeanConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(Constants.QUEUE);
    }
}
