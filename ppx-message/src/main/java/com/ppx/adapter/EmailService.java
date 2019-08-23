package com.ppx.adapter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Slf4j
@Service
public class EmailService implements MessageAdapter {
    @Override
    public void sendMsg(JSONObject body) {
        log.info("send email ");
        String email = body.getString("email");
        if (StringUtils.isEmpty(email)) {
            return;
        }

    }
}
