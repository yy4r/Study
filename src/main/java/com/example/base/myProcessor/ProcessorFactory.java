package com.example.base.myProcessor;

import com.example.base.myProcessor.context.EventContext;
import com.example.base.myProcessor.event.common.BeanHandlerEvent;
import com.example.base.myProcessor.node.Handler;
import com.example.base.myProcessor.node.common.AfterHandler;
import com.example.base.myProcessor.node.common.BeforeHandler;
import com.example.base.myProcessor.node.custom.CoustomHandler;
import com.example.base.myProcessor.node.service.ServiceHandler;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class ProcessorFactory implements BeanNameAware, ApplicationContextAware, InitializingBean {

    /**
     * 静态工厂
     */
    public static Map<String, Processor> factory = new ConcurrentHashMap<>();

    private String beanName;

    private ApplicationContext applicationContext;

    private Handler head;

    // TODO: 2020/12/1 可考虑更换成map
    private Map<String/**type*/, List<Processor>> map = new ConcurrentHashMap<>();

    private List<Processor> beforeList = new ArrayList<>();

    private List<Processor> serviceList = new ArrayList<>();

    private List<Processor> afterList = new ArrayList<>();

    private List<Processor> customList = new ArrayList<>();

    //工厂初始化编排
    @PostConstruct
    public void init() {
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
        //责任链事件编排
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
