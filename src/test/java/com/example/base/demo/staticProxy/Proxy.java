package com.example.base.demo.staticProxy;

public class Proxy implements Peo {

    Peo obj;

    public Proxy(){}

    public Proxy(Peo peo) {
        this.obj = peo;
    }

    @Override
    public void task() {
        before();
        obj.task();
        after();
    }

    public void before(){
        System.out.println("前置处理");
    }

    public void after(){
        System.out.println("后置处理");
    }
}
