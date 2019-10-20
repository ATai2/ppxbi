package com.ppx.power.event;

import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

@Data
public class StartEvent extends ApplicationContextEvent {

    private String content;
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public StartEvent(ApplicationContext source) {
        super(source);

    }
}
