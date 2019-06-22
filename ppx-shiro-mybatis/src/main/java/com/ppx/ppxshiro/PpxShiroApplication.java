package com.ppx.ppxshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ppx.ppxshiro.dao")
public class PpxShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxShiroApplication.class, args);
    }

}

