package com.ppx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ppx.dao")
public class PpxMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxMemberApplication.class, args);
    }

}

