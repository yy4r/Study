package com.example.base.myProcessor.strategy;

import com.example.base.myProcessor.Processor;
import com.example.base.myProcessor.ProcessorFactory;
import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;
import com.example.base.myProcessor.common.context.ProcessContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProcessorStrategyDispatcher implements ProcessorStrategy, ApplicationContextAware {

    @Autowired
    private ProcessorFactory factory;

    private ApplicationContext context;

    @Override
    public void dispatcher(ProcessContext context) {
        Processor processor = factory.getProcessor(context.getTypeEnum());
        processor.process(context);
    }

    /**
     * todo 策略选择算法
     */
    @Override
    public List<Processor> getProcessor(String type) {
        List<Processor> processors = new ArrayList<>();
        Class<Processor> clazz = (Class<Processor>) context.getBean(type).getClass();
        Map<String, Processor> beansOfType = context.getBeansOfType(clazz);
        beansOfType.entrySet().parallelStream().forEach((entry) -> {
            processors.add(entry.getValue());
        });
        return processors;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
