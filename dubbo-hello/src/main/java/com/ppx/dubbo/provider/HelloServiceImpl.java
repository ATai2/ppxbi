package com.ppx.dubbo.provider;

import com.ppx.dubbo.api.HelloService;


public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "Hello, "+userName;
    }
}
