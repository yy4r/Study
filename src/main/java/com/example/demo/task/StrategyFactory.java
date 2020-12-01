package com.example.demo.task;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
public class StrategyFactory {

    //策略容器
    private Map<String, Strategy> strategy;

}
