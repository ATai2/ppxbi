package com.ppx.ppxusermgt;

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
public class PpxUsermgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxUsermgtApplication.class, args);
    }
}
