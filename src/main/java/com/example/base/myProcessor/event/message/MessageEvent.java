package com.example.base.myProcessor.event.message;

import com.example.base.myProcessor.context.EventContext;
import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
    public MessageEvent(EventContext context) {
        super(context);
    }
}
