package com.ppx.ppxconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class PpxConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxConfigApplication.class, args);
    }
}
