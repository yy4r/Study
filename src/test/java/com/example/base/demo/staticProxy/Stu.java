package com.example.base.demo.staticProxy;

import lombok.Data;

@Data
public class Stu implements Peo {

    int age;

    @Override
    public void task() {
        System.out.println("我来了");
    }

}
