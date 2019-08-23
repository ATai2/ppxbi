package com.ppx.mq;

import com.alibaba.fastjson.JSONObject;
import com.ppx.adapter.EmailService;
import com.ppx.adapter.MessageAdapter;
import com.ppx.api.base.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class ConsumerDistribute {

    @Autowired
    EmailService emailService;

    MessageAdapter messageAdapter;

    @JmsListener(destination = Constants.QUEUE)
    public void distribute(String json) {
        log.info("===============receive msg content:==============", json);
        try {
            if (StringUtils.isEmpty(json)) {
                return;
            }
            JSONObject rootJson = new JSONObject().parseObject(json);
            JSONObject header = rootJson.getJSONObject("header");
            String interfaceType = rootJson.getString("interfaceType");

            if (StringUtils.isEmpty(interfaceType)) {
                return;
            }
            if (Constants.MSG_SMS.equalsIgnoreCase(interfaceType)) {
                messageAdapter=emailService;
            }

            if (messageAdapter == null) {
                return;
            }
            JSONObject content = rootJson.getJSONObject("content");
            messageAdapter.sendMsg(content);
        } catch (Exception e) {
            log.error("========================  error");
        }

    }
}
