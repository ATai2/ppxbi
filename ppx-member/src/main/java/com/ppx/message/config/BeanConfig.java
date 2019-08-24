package com.ppx.message.config;

import com.ppx.message.api.base.Constants;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class BeanConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(Constants.QUEUE);
    }
}
