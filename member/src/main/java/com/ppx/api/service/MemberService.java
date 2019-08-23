package com.ppx.api.service;

import com.ppx.api.base.ResponseBase;
import com.ppx.api.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
public interface MemberService {
    @GetMapping("/findUserById")
    ResponseBase findUserById(Long userId);

    @PostMapping("/reguser")
    ResponseBase regUser(@RequestBody UserEntity userEntity);



}
