package com.ppx.ppxorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class FilmService {
    @Resource
    RestTemplate restTemplate;

    public void getUser() {

    }
}
