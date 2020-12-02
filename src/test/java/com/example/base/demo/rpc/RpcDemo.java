package com.example.base.demo.rpc;

public class RpcDemo {

    public String test() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("调用成功");
        return "ok";
    }

}
