package com.example.base.myProcessor;

import com.example.base.myProcessor.node.common.after.AfterProcessor;
import com.example.base.myProcessor.node.common.before.BeforeProcessor;
import com.example.base.myProcessor.common.context.ProcessContext;
import com.example.base.myProcessor.node.custom.CustomProcessNode;
import com.example.base.myProcessor.node.service.ServiceProcessNode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Trigger implements InitializingBean, ApplicationContextAware{

    @Autowired
    private ProcessorExcutor excutor;

    private ApplicationContext applicationContext;

    public void trigger(ProcessContext context) {
        excutor.execute(context);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * factory编排 可后续考虑做个排序 todo 这里换成责任链
         */
        //前置处理
        Map<String, BeforeProcessor> beforeProcessorMap = applicationContext.getBeansOfType(BeforeProcessor.class);
        beforeProcessorMap.forEach((k, v) -> {
            excutor.addBeforeNode(v);
        });

        //服务编排
        Map<String, ServiceProcessNode> serviceProcessNodeMap = applicationContext.getBeansOfType(ServiceProcessNode.class);
        serviceProcessNodeMap.forEach((k, v) -> {
            excutor.addServiceNode(v);
        });

        //自定义处理
        Map<String, CustomProcessNode> customProcessNodeMap = applicationContext.getBeansOfType(CustomProcessNode.class);
        customProcessNodeMap.forEach((k, v) -> {
            excutor.addCustomNode(v);
        });

        //后置处理
        Map<String, AfterProcessor> afterProcessorMap = applicationContext.getBeansOfType(AfterProcessor.class);
        afterProcessorMap.forEach((k, v) -> {
            excutor.addAfterNode(v);
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
