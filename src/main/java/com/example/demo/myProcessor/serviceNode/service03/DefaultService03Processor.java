package com.example.demo.myProcessor.serviceNode.service03;

import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;
import com.example.demo.myProcessor.serviceNode.ServiceProcessNode;
import org.springframework.stereotype.Component;

@Component
public class DefaultService03Processor implements ServiceProcessNode {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("业务领域执行3");
        return new ProcessResult<>(true);
    }
}
