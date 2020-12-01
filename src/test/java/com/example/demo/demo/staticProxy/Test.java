package com.example.demo.demo.staticProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Test {

    public static void main(String[] args) throws Exception {
        //我想去找stu 执行任务 但是不能直接找 他不会暴露给我
        Stu stu = new Stu();
//        Class<?> clz = Class.forName("com.example.demo.demo.staticProxy.Stu");
//        Field age = clz.getDeclaredField("age");
//        Type genericType = age.getGenericType();
//        System.out.println(genericType);
        proxy(stu);
    }
    //传进来stu类型
    public static void proxy(Object object) throws Exception {
        if (object instanceof Peo){
//            Peo proxy = new Proxy((Peo) object);
            //后面的变成反射方式获取
            //这里可以自定义的代理类对象路径
            Class<?> clz = Class.forName("com.example.demo.demo.staticProxy.Proxy");

            //这里一切皆为obj
            Field f = clz.getDeclaredField("obj");
            Type type = f.getGenericType();
            Object peo = ((Class) type).cast(object);

            Object o = clz.newInstance();
            Method task = clz.getMethod("task");

            //给属性赋值
            f.set(o,peo);

            task.invoke(o);
        }
    }

}
