package com.example.base.myProcessor.common.annotation;

import com.example.base.myProcessor.node.custom.CustomProcessNode;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

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
         * 和spring解析注解一样，注解解析之后需要放进代理类
         */
//        Environment environment = applicationContext.getEnvironment();
//        String aaaa = environment.getProperty("aaaa");
        if (bean.getClass().isAnnotationPresent(ProcessType.class)) {
            ProcessType processType = bean.getClass().getAnnotation(ProcessType.class);
            ((CustomProcessNode) bean).setTypeEnum(processType.type());
        }
        return bean;
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ProcessType.class)) {
            Class<?> clazz = bean.getClass();
            Field field = clazz.getDeclaredField("value");
            if (field!=null){
                Object o = field.get(bean);
                System.out.println(o.toString());
            }
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
