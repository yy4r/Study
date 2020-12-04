package com.example.base.myProcessor.node.serviceNode.order;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultService01Processor implements Service01Processor {

    private String beanName;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getServices().contains(beanName)){
            System.out.println("业务领域执行1");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
