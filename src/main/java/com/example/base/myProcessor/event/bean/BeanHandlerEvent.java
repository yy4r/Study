package com.example.base.myProcessor.event.bean;

import com.example.base.myProcessor.common.context.EventContext;
import org.springframework.context.ApplicationEvent;

public class BeanHandlerEvent extends ApplicationEvent {
    public BeanHandlerEvent(EventContext context) {
        super(context);
    }
}
