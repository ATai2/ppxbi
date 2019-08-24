package com.ppx.common.message.ppxusermgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PpxUsermgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxUsermgtApplication.class, args);
    }
}
