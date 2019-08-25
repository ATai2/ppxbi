package com.ppx.px;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PpxPxWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxPxWebApplication.class, args);
    }
}
