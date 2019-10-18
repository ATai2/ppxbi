package com.ppx.ws.controller;

import com.ppx.ws.ActorEntity;
import com.ppx.ws.entity.Greeting;
import com.ppx.ws.entity.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller

public class MsgController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println(message.toString());
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/hello1")
    @SendTo("/topic/greetings1")
    public Greeting greeting1(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println(message.toString());
        return new Greeting("Hello1, " + message.getName() + "!");
    }

    @MessageMapping("/spittle")
    @SendToUser("/user/notifications")
    public String handleSpittle(
            Principal principal, HelloMessage message) {

        return "sssss";
    }

//    @GetMapping("severSend")
//    public String serverSend(){
//        simpMessagingTemplate.convertAndSend("/topic/ssmsg","finished test");
//        return "";
//    }


    @MessageMapping("/ppx/chat")
    public String broadCast(Message<ActorEntity> msg) {
        ActorEntity payload = msg.getPayload();
        System.out.println(payload.toString());
        return "chat";
    }

    @MessageMapping("/test")
    public String test(Message<String> msg) {
        String payload = msg.getPayload();
        System.out.println(payload);
        return "1055";
    }
}
