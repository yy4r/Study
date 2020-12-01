package com.example.demo.task;

import org.springframework.context.ApplicationListener;

public interface Strategy extends ApplicationListener {

    //调用前和调用后需要做切入
    void doing();

}
