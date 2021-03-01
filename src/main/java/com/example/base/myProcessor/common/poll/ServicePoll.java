package com.example.base.myProcessor.common.poll;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  todo 线程池做接口隔离，后续不同领域使用不同领域的线程池 （修改->做个面向接口编程）
 *
 *  为什么tomcat有线程池之后 还需要下层线程池
 *  1、领域隔离 互不影响 2、比如tomcat同一时间只能并发100个，但每个接口内部又开线程，这样子真正服务器的线程数并不是100个
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
