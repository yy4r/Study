package com.example.base.myProcessor.annotation;

import com.example.base.myProcessor.node.customNode.CustomProcessNode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        /**
         * 后续可考虑从配置中心拉 做动态解耦
         */
//        Environment environment = applicationContext.getEnvironment();
//        String aaaa = environment.getProperty("aaaa");
        if (bean.getClass().isAnnotationPresent(NodeType.class)) {
            NodeType nodeType = bean.getClass().getAnnotation(NodeType.class);
            ((CustomProcessNode) bean).setType(nodeType.type());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
