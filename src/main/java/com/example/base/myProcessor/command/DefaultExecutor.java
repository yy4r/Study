package com.example.base.myProcessor.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Jack
 * @date 2021/3/1 8:32 下午
 */
public class DefaultExecutor implements Executor{

    @Autowired
    private ApplicationContext context;

    @Override
    public void executor(String name, List<String> actions) {
        Object bean = context.getBean(name);
        Class<?> clazz = bean.getClass();
        actions.forEach((action)->{
            try {
                Method method = clazz.getMethod(action);
                method.invoke(bean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
