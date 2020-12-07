package com.example.base.myProcessor.poll;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  todo 线程池做接口隔离，不同领域使用不同领域的线程池
 */
@Component
@Data
public class ServicePoll implements InitializingBean {

    @Value("100")
    private int corePoolSize;

    @Value("100")
    private int maximumPoolSize;

    private ExecutorService executorService;


    @Override
    public void afterPropertiesSet() throws Exception {
        this.executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 3L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }
}
