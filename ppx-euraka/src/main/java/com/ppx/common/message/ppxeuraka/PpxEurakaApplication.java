package com.ppx.common.message.ppxeuraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PpxEurakaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PpxEurakaApplication.class, args);
    }
}
