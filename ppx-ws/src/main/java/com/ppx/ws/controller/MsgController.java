package com.ppx.ws.controller;

import com.ppx.ws.ActorEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MsgController {

    @MessageMapping("/chat")
    public String broadCast(Message<ActorEntity> msg){
        ActorEntity payload = msg.getPayload();
        System.out.println(payload.toString());
        return "";
    }
}
