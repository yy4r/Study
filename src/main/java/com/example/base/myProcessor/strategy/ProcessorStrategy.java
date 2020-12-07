package com.example.base.myProcessor.strategy;

import com.example.base.myProcessor.Processor;

import java.util.List;

public interface ProcessorStrategy {
    /**
     * todo 做个策略选择器
     * > 后续如果需要单独隔离的触发某一个activity 这里做一个分发器
     */
    List<Processor> getProcessor(String type);
}
