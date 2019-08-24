package com.ppx.message.controller;

import com.alibaba.fastjson.JSONObject;
import com.ppx.message.api.base.BaseApiService;
import com.ppx.message.api.base.Constants;
import com.ppx.message.api.base.ResponseBase;
import com.ppx.message.api.entity.UserEntity;
import com.ppx.message.api.service.MemberService;
import com.ppx.message.dao.MemberDao;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

//import com.ppx.api.mq.RegisterMailboxProducer;

@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {
    @Value("${MESSAGEQUEE}")
    private String MESSAGEQUEE;
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;

    @PostConstruct
    void sendong(){
        sendMsg(emailJson("l1111111"));
    }
    @Override
    public ResponseBase findUserById(Long userId) {

        UserEntity userEntity = memberDao.findByID(userId);
        if (userEntity == null) {
            return setError("Can't find user");
        }
        return setResultSuccess(userEntity);
    }

    @Override
    public ResponseBase regUser(@RequestBody UserEntity userEntity) {
        // parameter varify
        String password = userEntity.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setError("password not null");
        }
        Integer insertUser = memberDao.insertUser(userEntity);
        if (insertUser <= 0) {
            return setError("reg error");
        }

        sendMsg(emailJson(userEntity.getEmail()));
        return setResultSuccess("reg success");
    }

    @Override
    public ResponseBase login(@RequestBody UserEntity userEntity) {

        return null;
    }

    private String emailJson(String email) {
        JSONObject rootJson = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", Constants.MSG_SMS);
        JSONObject content = new JSONObject();
        content.put("email", email);
        rootJson.put("header", header);
        rootJson.put("content", content);
        return rootJson.toJSONString();
    }

    private void sendMsg(String json) {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue(Constants.QUEUE);
        registerMailboxProducer.sendMsg(activeMQQueue, json);

    }
}
