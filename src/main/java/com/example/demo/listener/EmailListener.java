package com.example.demo.listener;

import com.example.demo.event.EmailEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<EmailEvent> {


    @Override
    public void onApplicationEvent(EmailEvent emailEvent) {

            System.out.println("收到邮件");
            emailEvent.test();
    }

}
