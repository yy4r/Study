package com.example.demo.myProcessor.message;

import org.springframework.context.ApplicationEvent;

public class MessageContext extends ApplicationEvent {
    public MessageContext(String message) {
        super(message);
    }
}
