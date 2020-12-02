package com.example.base.demo.reflection;

import lombok.Data;

@Data
public class Stu {

    int age;
    String name;

    public void task(){
        System.out.println("go go go");
    }

}
