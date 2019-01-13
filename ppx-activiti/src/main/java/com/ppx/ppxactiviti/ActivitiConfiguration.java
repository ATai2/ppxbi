package com.ppx.ppxactiviti;

import org.activiti.rest.common.application.ContentTypeResolver;
import org.activiti.rest.common.application.DefaultContentTypeResolver;
import org.activiti.rest.service.api.RestResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfiguration {
    @Bean
    public RestResponseFactory restResponseFactory(){
        return new RestResponseFactory();
    }
    @Bean
    public ContentTypeResolver contentTypeResolver(){
        return new DefaultContentTypeResolver();
    }
}
