package com.example.base.myProcessor.node.serviceNode.order;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultOrderProcessor implements OrderProcessor {

    private String beanName;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getServices().contains(beanName)){
            System.out.println("执行订单相关业务");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
