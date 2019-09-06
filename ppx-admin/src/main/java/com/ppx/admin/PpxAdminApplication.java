package com.ppx.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ppx.ppxlitemalldb", "com.ppx.common.ppxutil","com.ppx.admin"})
@MapperScan("com.ppx.ppxlitemalldb.dao")
public class PpxAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxAdminApplication.class, args);
    }

}

