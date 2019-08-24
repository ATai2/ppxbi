package com.ppx.common.message.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppx.common.base.Constants;
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
