package com.ppx.ppxactiviti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
//@ComponentScan("org.activiti.rest")
@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class PpxActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxActivitiApplication.class, args);
    }

}

