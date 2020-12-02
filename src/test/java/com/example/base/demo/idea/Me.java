package com.example.base.demo.idea;

import com.example.base.demo.rpc.RpcDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Me {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("1");
        RpcDemo rpc = new RpcDemo();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            Future<String> submit = cachedThreadPool.submit(() -> {
                return rpc.test();
            });
            String s = submit.get();
        }

        Future<String> submit = cachedThreadPool.submit(() -> {
            return "aaaaaa";
        });
    }

    public void futureTest(){


    }


}
