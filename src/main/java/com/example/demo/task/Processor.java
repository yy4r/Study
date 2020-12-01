package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Processor {

    @Autowired
    private StrategyFactory strategyFactory;

    public void doing(String type) {
        Map<String, Strategy> strategy = strategyFactory.getStrategy();
        Strategy strategy0 = strategy.get(type);
        strategy0.doing();
    }


}
