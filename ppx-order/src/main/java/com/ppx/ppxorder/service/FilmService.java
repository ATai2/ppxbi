package com.ppx.ppxorder.service;

import com.ppx.ppxorder.entity.PpxUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilmService {
    @Resource
    RestTemplate restTemplate;
    @Resource
    UserInterface userInterface;

    public List<PpxUser> getUser() {
       return userInterface.getUsers();
    }
}
