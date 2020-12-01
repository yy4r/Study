package com.example.demo.demo.staticProxy;

import lombok.Data;

@Data
public class Stu implements Peo {

    int age;

    @Override
    public void task() {
        System.out.println("我来了");
    }

}
