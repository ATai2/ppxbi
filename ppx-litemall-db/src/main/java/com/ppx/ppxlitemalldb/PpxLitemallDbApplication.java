package com.ppx.ppxlitemalldb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ppx.ppxlitemalldb")
@MapperScan("com.ppx.ppxlitemalldb.dao")
public class PpxLitemallDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(PpxLitemallDbApplication.class, args);
    }
}
