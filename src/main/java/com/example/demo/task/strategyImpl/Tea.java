package com.example.demo.task.strategyImpl;

import com.example.demo.task.Strategy;
import com.example.demo.task.event.EmailEvent;
import com.example.demo.task.event.Message;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class Tea implements Strategy {
    @Override
    public void doing() {
        System.out.println("上课");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof EmailEvent){
            Object source = applicationEvent.getSource();
            Message message = (Message) source;
            System.out.println(message);
        }
    }

}
