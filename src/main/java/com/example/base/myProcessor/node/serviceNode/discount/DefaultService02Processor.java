package com.example.base.myProcessor.node.serviceNode.discount;

import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.context.ProcessContext;
import org.springframework.stereotype.Component;

@Component
public class DefaultService02Processor implements Service02Processor {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("业务领域执行2");
        return ProcessResult.builder().isSuccess(true).build();
    }
}
