package com.example.demo.myProcessor.serviceNode.service01;

import com.example.demo.component.T;
import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultService01Processor implements Service01Processor {
    @Override
    public ProcessResult<T> process(ProcessContext context) {
        System.out.println("业务领域执行1");
        return new ProcessResult<>(true);
    }
}
