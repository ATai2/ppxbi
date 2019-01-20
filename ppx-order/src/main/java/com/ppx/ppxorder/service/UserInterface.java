package com.ppx.ppxorder.service;

import com.ppx.ppxorder.entity.PpxUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "ppx-userManagement")
public interface UserInterface {
    @RequestMapping(value = "/users")
    List<PpxUser> getUsers();
}
