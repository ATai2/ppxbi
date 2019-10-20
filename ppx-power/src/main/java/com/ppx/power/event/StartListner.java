package com.ppx.power.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartListner  implements ApplicationListener<StartEvent> {


    @Override
    public void onApplicationEvent(StartEvent event) {
        System.out.println("Spring context start.");
        System.out.println(event.getContent());

    }
}
