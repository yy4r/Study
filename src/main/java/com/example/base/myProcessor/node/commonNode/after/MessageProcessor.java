package com.example.base.myProcessor.node.commonNode.after;

import com.example.base.myProcessor.event.EventContext;
import com.example.base.myProcessor.event.message.MessageEvent;
import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor implements AfterProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public ProcessResult process(ProcessContext context) {
        //消息处理
        String message = context.getMessage();
        EventContext eventContext = EventContext.builder().message(message).build();
        MessageEvent messageEvent = new MessageEvent(eventContext);
        applicationContext.publishEvent(messageEvent);
        return new ProcessResult(true);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
