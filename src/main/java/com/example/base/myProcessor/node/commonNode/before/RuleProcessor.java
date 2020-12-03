package com.example.base.myProcessor.node.commonNode.before;

import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.context.ProcessContext;
import org.springframework.stereotype.Component;

@Component
public class RuleProcessor implements BeforeProcessor {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("规则校验");
        return ProcessResult.builder().isSuccess(true).build();
    }
}
