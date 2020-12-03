package com.example.base.myProcessor.event.message;

import com.example.base.myProcessor.context.EventContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        EventContext context = (EventContext) messageEvent.getSource();
        System.out.println(context.getMessage());
    }
}
