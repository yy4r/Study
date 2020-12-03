package com.example.base.myProcessor.event.common;

import com.example.base.myProcessor.context.EventContext;
import org.springframework.context.ApplicationEvent;

public class BeanHandlerEvent extends ApplicationEvent {
    public BeanHandlerEvent(EventContext context) {
        super(context);
    }
}
