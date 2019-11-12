package com.ppx.soufang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@RibbonClients({@RibbonClient=})
//@EnableHystrix
//@EnableHystrixDashboard
public class SoufangApp {

    public static void main(String[] args) {
        SpringApplication.run(SoufangApp.class, args);
    }
}