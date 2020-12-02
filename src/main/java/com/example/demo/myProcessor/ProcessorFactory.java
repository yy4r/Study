package com.example.demo.myProcessor;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class ProcessorFactory implements BeanNameAware, ApplicationContextAware {

    private String beanName;

    private ApplicationContext applicationContext;

    private Map<String, Processor> factory = new ConcurrentHashMap<>();
    // TODO: 2020/12/1 可考虑更换成map
    private Map<String, List<Processor>> map = new ConcurrentHashMap<>();

    private List<Processor> beforeList = new ArrayList<>();

    private List<Processor> serviceList = new ArrayList<>();

    private List<Processor> afterList = new ArrayList<>();

    //工厂初始化
    @PostConstruct
    public void init() {
        String[] names = applicationContext.getBeanNamesForType(ProcessorFactory.class);
        System.out.println(Arrays.toString(names)+beanName);
        Map<String, Processor> beansOfType = applicationContext.getBeansOfType(Processor.class);
        factory.putAll(beansOfType);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
