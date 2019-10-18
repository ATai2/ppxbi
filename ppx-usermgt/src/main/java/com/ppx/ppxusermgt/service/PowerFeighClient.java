package com.ppx.ppxusermgt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PPX-POWER")
public interface PowerFeighClient {

    @GetMapping("/power")
    public Object getPower();
}
