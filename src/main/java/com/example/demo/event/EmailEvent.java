package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {

    public EmailEvent(Object o) {
        super(o);
    }

    public void test(){
        System.out.println("hello");
    }

}
