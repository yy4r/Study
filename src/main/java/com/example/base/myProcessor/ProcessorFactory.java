package com.example.base.myProcessor;

import com.example.base.myProcessor.common.annotation.ProcessType;
import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;
import com.example.base.myProcessor.common.context.EventContext;
import com.example.base.myProcessor.event.bean.BeanHandlerEvent;
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
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class ProcessorFactory implements BeanNameAware, ApplicationContextAware, InitializingBean {

    //todo 后续考虑做一个bean容器，通过bean容器做自动化分发策略选择
    private Container container = new Container();
    /**
     * 静态工厂   初始化做编排故r t y目前线程不安全的问题不会发生，用并发map的原因是考虑到以后动态的registry执行器的
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


    @Override//contants
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Class[] types = new Class[]{Processor.class};
        System.out.println(types);
        for (Class type : types) {
            Map map = applicationContext.getBeansOfType(type);
            for (Object o : map.values()) {
                ProcessType processType = o.getClass().getAnnotation(ProcessType.class);
            }
        }
    }

    /**
     * todo bean容器
     */
    private static class Container {

        private final Map<Class, Map<ProcessorTypeEnum, Object>> beanMap;


        private Container() {
            this.beanMap = new HashMap<>();
        }

        public void put(Class clazz, ProcessorTypeEnum processorTypeEnum, Object bean) {
            Map<ProcessorTypeEnum, Object> activityTypeEnumObjectMap = beanMap.get(clazz);
            if (activityTypeEnumObjectMap == null) {
                activityTypeEnumObjectMap = new HashMap<>();
                activityTypeEnumObjectMap.put(processorTypeEnum, bean);
                beanMap.put(clazz, activityTypeEnumObjectMap);
            } else {
                beanMap.get(clazz).put(processorTypeEnum, bean);
            }
        }

        public Map<ProcessorTypeEnum, Object> get(Class clazz, ProcessorTypeEnum processorTypeEnum) {
            Map<ProcessorTypeEnum, Object> processorTypeEnumObjectMap = beanMap.get(clazz);
            if (processorTypeEnum == null || "".equals(processorTypeEnum.getType())) {
                return processorTypeEnumObjectMap;
            }
            Map<ProcessorTypeEnum, Object> newProcessorTypeEnumObjectMap = new HashMap<>();
            newProcessorTypeEnumObjectMap.put(processorTypeEnum, processorTypeEnumObjectMap.get(processorTypeEnum));
            return newProcessorTypeEnumObjectMap;
        }
    }

}
