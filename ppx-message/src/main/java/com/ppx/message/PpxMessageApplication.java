package com.ppx.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PpxMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxMessageApplication.class, args);
    }
}
