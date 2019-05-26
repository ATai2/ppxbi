package com.ppx.ppxshiro.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    public void aopService(){
        System.out.println("loginservice");
        log.info("aop");
    }
}
