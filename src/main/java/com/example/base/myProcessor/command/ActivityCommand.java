package com.example.base.myProcessor.command;

import org.springframework.stereotype.Component;

/**
 * @author Jack
 * @date 2021/3/1 8:31 下午
 */
@Component
public class ActivityCommand {

    private void action0(){
        System.out.println("执行action0");
    }

    private void action1(){
        System.out.println("执行action1");
    }
}
