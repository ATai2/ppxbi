package com.ppx.power.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyEventMain {
    @Autowired
    ApplicationContext applicationContext;

    public void sendEvent(){
        StartEvent event = new StartEvent(applicationContext);
        event.setContent("hello event");
        applicationContext.publishEvent(event);
//        applicationContext.
    }
}
