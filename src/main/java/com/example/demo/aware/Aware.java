package com.example.demo.aware;

import com.example.demo.event.EmailEvent;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Data
public class Aware implements BeanNameAware, ApplicationContextAware {

    ApplicationContext applicationContext;

    String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void pulishEmailEvent(){
        applicationContext.publishEvent(new EmailEvent(new Object()));
    }

}
