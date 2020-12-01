package com.example.demo.demo.idea;

import com.example.demo.demo.rpc.RpcDemo;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {

        RpcDemo rpc = new RpcDemo();

        for (int i = 0;i<100;i++){
            System.out.println(i);
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try {
                    String test = rpc.test();
                    return test;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "";
            });
            future.whenComplete(new BiConsumer<String, Throwable>() {
                @Override
                public void accept(String s, Throwable throwable) {
                    System.out.println(s);
                }
            });
        }
        Thread.sleep(80000);

    }
}
