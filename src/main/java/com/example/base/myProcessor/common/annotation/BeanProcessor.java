package com.example.base.myProcessor.common.annotation;

import com.example.base.myProcessor.node.custom.CustomProcessNode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanProcessor implements BeanPostProcessor, ApplicationContextAware {

    /**
     * 未使用（暂留） 后置处理器预计会使用
     */
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        /**
         * 后续可考虑从配置中心拉 做动态解耦
         */
//        Environment environment = applicationContext.getEnvironment();
//        String aaaa = environment.getProperty("aaaa");
        if (bean.getClass().isAnnotationPresent(ProcessType.class)) {
            ProcessType processType = bean.getClass().getAnnotation(ProcessType.class);
            ((CustomProcessNode) bean).setType(processType.type());
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
