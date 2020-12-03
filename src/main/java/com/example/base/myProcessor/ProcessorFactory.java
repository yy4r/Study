package com.example.base.myProcessor;

import com.example.base.myProcessor.event.EventContext;
import com.example.base.myProcessor.event.common.BeanHandlerEvent;
import com.example.base.myProcessor.node.Handler;
import com.example.base.myProcessor.node.commonNode.AfterHandler;
import com.example.base.myProcessor.node.commonNode.BeforeHandler;
import com.example.base.myProcessor.node.customNode.CoustomHandler;
import com.example.base.myProcessor.node.serviceNode.ServiceHandler;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
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
public class ProcessorFactory implements BeanNameAware, ApplicationContextAware, InitializingBean {

    private String beanName;

    private ApplicationContext applicationContext;

    private Handler head;

    private Map<String, Processor> factory = new ConcurrentHashMap<>();
    // TODO: 2020/12/1 可考虑更换成map
    private Map<String/**type*/, List<Processor>> map = new ConcurrentHashMap<>();

    private List<Processor> beforeList = new ArrayList<>();

    private List<Processor> serviceList = new ArrayList<>();

    private List<Processor> afterList = new ArrayList<>();

    private List<Processor> customList = new ArrayList<>();

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

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Handler> handlers = new ArrayList<>();
        //责任链事件
        BeforeHandler beforeHandler = applicationContext.getBean(BeforeHandler.class);
        CoustomHandler coustomHandler = applicationContext.getBean(CoustomHandler.class);
        ServiceHandler serviceHandler = applicationContext.getBean(ServiceHandler.class);
        AfterHandler afterHandler = applicationContext.getBean(AfterHandler.class);
        handlers.add(beforeHandler);
        handlers.add(coustomHandler);
        handlers.add(serviceHandler);
        handlers.add(afterHandler);
        head = beforeHandler;
        EventContext eventContext = EventContext.builder().handlers(handlers).build();
        applicationContext.publishEvent(new BeanHandlerEvent(eventContext));
    }
}
