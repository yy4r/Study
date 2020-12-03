package com.example.base.myProcessor.strategy;

import com.example.base.myProcessor.Processor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProcessorStrategySelector implements ProcessorStrategy, ApplicationContextAware {

    private ApplicationContext context;

    /**
     * todo 策略选择算法
     */
    @Override
    public List<Processor> getProcessor(String type) {
        List<Processor> processors = new ArrayList<>();
        Class<Processor> clazz = (Class<Processor>) context.getBean(type).getClass();
        Map<String, Processor> beansOfType = context.getBeansOfType(clazz);
        beansOfType.forEach((k, v) -> {
            processors.add(v);
        });
        return processors;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
