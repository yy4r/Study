package com.example.demo.task.event;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {

    public EmailEvent(Message message) {
        super(message);
    }

}
