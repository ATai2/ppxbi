package com.ppx.common.ppxutil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ppx.ppxlitemalldb", "com.ppx.common.ppxutil"})
@MapperScan("com.ppx.ppxlitemalldb.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}