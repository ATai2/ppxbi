package com.ppx.common.message.adapter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class EmailService implements MessageAdapter {

    @Value("${msg.subject}")
    private String subject;
    @Value("${msg.text}")
    private String text;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendMsg(JSONObject body) {
        log.info("send email ");
        String email = body.getString("email");
        if (StringUtils.isEmpty(email)) {
            return;
        }

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("wangtaihe567@163.com");
        simpleMailMessage.setTo("wangtaihe567@163.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

        log.info("reg send email");
    }
}
