package com.example.demo.myProcessor.commonNode.after;

import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;
import com.example.demo.myProcessor.message.MessageContext;
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
        MessageContext messageContext = new MessageContext(message);
        applicationContext.publishEvent(messageContext);
        return new ProcessResult(true);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
