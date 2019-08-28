package com.ppx.member.config;

import com.ppx.common.constants.Constants;
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
