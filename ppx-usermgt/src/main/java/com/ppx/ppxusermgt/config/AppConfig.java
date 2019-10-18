package com.ppx.ppxusermgt.config;

import com.netflix.loadbalancer.IRule;
import com.ppx.ppxusermgt.rule.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule getRule(){
        return new MyRule();
    }
}
