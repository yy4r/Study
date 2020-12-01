package com.example.demo.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception {
//        System.out.println("hello world");
        Class clz = Class.forName("com.example.demo.demo.reflection.Stu");
        Stu stu = (Stu) clz.newInstance();
        stu.task();
        ClassLoader classLoader = clz.getClassLoader();
        System.out.println(classLoader);
        Method task = clz.getMethod("task");
        task.invoke(stu);
    }

}
