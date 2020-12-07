package com.example.base.myProcessor.node.service.prize;

import com.example.base.myProcessor.common.context.ProcessContext;
import com.example.base.myProcessor.common.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultPrizeProcessor implements PrizeProcessor {

    private String beanName;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getServices().contains(beanName)){
            System.out.println("执行奖品相关业务");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
