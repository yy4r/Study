package com.example.base.myProcessor.node.commonNode.before;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class InitProcessor implements BeforeProcessor {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("初始化");
        return ProcessResult.builder().isSuccess(true).build();
    }
}
