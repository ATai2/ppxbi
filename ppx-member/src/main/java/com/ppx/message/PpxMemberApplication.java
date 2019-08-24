package com.ppx.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;

@EnableEurekaClient
@EnableJms
@SpringBootApplication
@MapperScan("com.ppx.dao")
public class PpxMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxMemberApplication.class, args);
    }

}
