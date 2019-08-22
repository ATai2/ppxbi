package com.ppx.ppxshiro.service.impl;

import com.ppx.api.service.MemberService;
import com.ppx.ppxshiro.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public com.ppx.base.ResponseBase findUserById(Long userId) {
        return memberDao.findByID(userId);
    }
}
