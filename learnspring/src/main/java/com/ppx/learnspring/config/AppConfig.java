package com.ppx.learnspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ppx.learnspring")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
