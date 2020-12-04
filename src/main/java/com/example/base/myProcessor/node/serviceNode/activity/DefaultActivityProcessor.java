package com.example.base.myProcessor.node.serviceNode.activity;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultActivityProcessor implements ActivityProcessor {

    private String beanName;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getServices().contains(beanName)){
            System.out.println("执行促销相关业务");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
