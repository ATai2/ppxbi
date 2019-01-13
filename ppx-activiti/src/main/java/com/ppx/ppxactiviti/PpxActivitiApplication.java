package com.ppx.ppxactiviti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("org.activiti.rest")
@SpringBootApplication
public class PpxActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxActivitiApplication.class, args);
    }

}

