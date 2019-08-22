package com.ppx.service.impl;

import com.ppx.api.base.BaseApiService;
import com.ppx.api.base.ResponseBase;
import com.ppx.api.entity.UserEntity;
import com.ppx.api.service.MemberService;
import com.ppx.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public ResponseBase findUserById(Long userId) {

        UserEntity userEntity = memberDao.findByID(userId);
        if (userEntity == null) {
            return setError("Can't find user");
        }
        return setResultSuccess(userEntity);
    }
}
