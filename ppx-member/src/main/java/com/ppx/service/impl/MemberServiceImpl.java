//package com.ppx.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.ppx.api.base.BaseApiService;
//import com.ppx.api.base.Constants;
//import com.ppx.api.base.ResponseBase;
//import com.ppx.api.entity.UserEntity;
//import com.ppx.api.service.MemberService;
//import com.ppx.dao.MemberDao;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.PostConstruct;
//
////import com.ppx.api.mq.RegisterMailboxProducer;
//
//@RestController
//public class MemberServiceImpl extends BaseApiService implements MemberService {
//    @Value("${MESSAGEQUEE}")
//    private String MESSAGEQUEE;
//    @Autowired
//    private MemberDao memberDao;
//
//    @Autowired
//    private RegisterMailboxProducer registerMailboxProducer;
//
//    @PostConstruct
//    void sendong(){
//        sendMsg(emailJson("l1111111"));
//    }
//    @Override
//    public ResponseBase findUserById(Long userId) {
//
//        UserEntity userEntity = memberDao.findByID(userId);
//        if (userEntity == null) {
//            return setError("Can't find user");
//        }
//        return setResultSuccess(userEntity);
//    }
//
//    @Override
//    public ResponseBase regUser(@RequestBody UserEntity userEntity) {
//        // parameter varify
//        String password = userEntity.getPassword();
//        if (StringUtils.isEmpty(password)) {
//            return setError("password not null");
//        }
//        Integer insertUser = memberDao.insertUser(userEntity);
//        if (insertUser <= 0) {
//            return setError("reg error");
//        }
//
//        sendMsg(emailJson(userEntity.getEmail()));
//        return setResultSuccess("reg success");
//    }
//
//    private String emailJson(String email) {
//        JSONObject rootJson = new JSONObject();
//        JSONObject header = new JSONObject();
//        header.put("interfaceType", Constants.MSG_SMS);
//        JSONObject content = new JSONObject();
//        content.put("email", email);
//        rootJson.put("header", header);
//        rootJson.put("content", content);
//        return rootJson.toJSONString();
//    }
//
//    private void sendMsg(String json) {
//        ActiveMQQueue activeMQQueue = new ActiveMQQueue(MESSAGEQUEE);
//        registerMailboxProducer.sendMsg(activeMQQueue, json);
//
//    }
//}
