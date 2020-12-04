package com.example.base.myProcessor.node.serviceNode.discount;

import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.context.ProcessContext;
import org.springframework.stereotype.Component;

@Component
public class DefaultDiscountProcessor implements DiscountProcessor {

    private String beanName;

    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("业务领域执行2");
        return ProcessResult.builder().isSuccess(true).build();
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
