package com.example.base.myProcessor.strategy;

import com.example.base.myProcessor.Processor;

import java.util.List;

public interface ProcessorStrategy {
    /**
     * todo 做个策略选择器
     */
    List<Processor> getProcessor(String type);
}
