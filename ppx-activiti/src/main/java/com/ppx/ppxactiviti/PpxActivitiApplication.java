package com.ppx.ppxactiviti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = {
//                org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
//                org.activiti.spring.boot.SecurityAutoConfiguration.class 
//        })
@SpringBootApplication
public class PpxActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxActivitiApplication.class, args);
    }

}

