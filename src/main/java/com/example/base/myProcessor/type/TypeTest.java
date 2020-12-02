package com.example.base.myProcessor.type;

import com.example.base.myProcessor.annotation.NodeType;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;

@Component
@Data
@NodeType(type = "type",group = "group")
public class TypeTest implements BeanPostProcessor, ApplicationContextAware {

    private String type;

    private String group;

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Environment environment = applicationContext.getEnvironment();
        String aaaa = environment.getProperty("aaaa");
        if(beanName.equals("typeTest")){
            System.out.println(11111);
        }
        if (bean.getClass().isAnnotationPresent(NodeType.class)){
            NodeType nodeType = bean.getClass().getAnnotation(NodeType.class);
            ((TypeTest)bean).setGroup(nodeType.group());
            ((TypeTest)bean).setType(nodeType.type());
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
