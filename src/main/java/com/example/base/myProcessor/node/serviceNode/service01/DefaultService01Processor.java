package com.example.base.myProcessor.node.serviceNode.service01;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultService01Processor implements Service01Processor {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("业务领域执行1");
        return ProcessResult.builder().isSuccess(true).build();
    }
}
