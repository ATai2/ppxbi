package com.ppx.api.service;

import com.ppx.api.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface MemberService {
    @RequestMapping("/findUserById")
    ResponseBase findUserById(Long userId);
}
