package com.ppx.message.api.service;

import com.ppx.message.api.base.ResponseBase;
import com.ppx.message.api.entity.UserEntity;
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
