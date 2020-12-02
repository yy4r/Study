package com.example.base.myProcessor.message;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements ApplicationListener<MessageContext> {
    @Override
    public void onApplicationEvent(MessageContext messageContext) {
        System.out.println("收到消息"+messageContext.getSource());
    }
}
