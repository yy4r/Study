package com.example.demo.task;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextFactory implements ApplicationContextAware {

    public static ApplicationContext context;

    @Autowired
    StrategyFactory strategy;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        //策略初始化
        strategy.setStrategy(applicationContext.getBeansOfType(Strategy.class));
    }
}
