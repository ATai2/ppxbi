package com.ppx.soufang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@RibbonClients({@RibbonClient=})
@EnableHystrix
@EnableHystrixDashboard
public class SoufangApp {

    public static void main(String[] args) {
        SpringApplication.run(SoufangApp.class, args);
    }
}