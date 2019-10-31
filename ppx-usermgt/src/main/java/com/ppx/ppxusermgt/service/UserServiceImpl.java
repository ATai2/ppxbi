package com.ppx.ppxusermgt.service;

import com.ppx.core.net.CommonResp;
import com.ppx.ppxusermgt.dao.UserDao;
import com.ppx.ppxusermgt.entity.NullValueResultDO;
import com.ppx.ppxusermgt.entity.PpxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserDao userDao;
    @Autowired
    ValueOperations<String, Object> valueOperations;

    public PpxUser insertUser(PpxUser user) {
        return userDao.save(user);
    }

    public CommonResp<Object> synchronizedSelectUserById(Long id) {
        Object o = valueOperations.get(String.valueOf(id));
        if (o != null) {
            if (o instanceof NullValueResultDO) {
                return new CommonResp<Object>().setCode(500).setMsg("99").setData(o);
            }else{
                return new CommonResp<Object>().setCode(200).setMsg("99").setData(o);
            }
        }

        PpxUser byUserId = userDao.findByUserId(id);
        if (byUserId == null) {
            valueOperations.set(String.valueOf(id), new NullValueResultDO());
        }
        valueOperations.set(String.valueOf(id), byUserId);
        return new CommonResp<>().setCode(200).setMsg("99").setData(byUserId);
    }


}
