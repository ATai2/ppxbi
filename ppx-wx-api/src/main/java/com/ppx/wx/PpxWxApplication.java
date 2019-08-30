package com.ppx.wx;

import com.ppx.common.base.BaseApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableFeignClients
@EnableEurekaClient
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        value = {BaseApiService.class})})
@SpringBootApplication
public class PpxWxApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxWxApplication.class, args);
    }
}
