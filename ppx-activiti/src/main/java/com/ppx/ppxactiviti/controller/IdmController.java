package com.ppx.ppxactiviti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController

public class IdmController {
    @RequestMapping("/app/rest/authenticate")
    public String user(HttpServletRequest request) {
        return "{\"login\":\"shareiu@share\"}";
    }
    @RequestMapping("/app/rest/account")
    public String account(HttpServletRequest request) {
        return "{\"id\":\"admin\",\"firstName\":null,\"lastName\":\"Administrator\",\"email\":\"admin\",\"fullName\":\" Administrator\",\"groups\":[{\"id\":\"ROLE_ADMIN\",\"name\":\"Superusers\",\"type\":\"security-role\"}]}";
    }
}
