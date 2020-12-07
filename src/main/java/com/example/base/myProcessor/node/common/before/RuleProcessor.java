package com.example.base.myProcessor.node.common.before;

import com.example.base.myProcessor.common.context.ProcessResult;
import com.example.base.myProcessor.common.context.ProcessContext;
import org.springframework.stereotype.Component;

@Component
public class RuleProcessor implements BeforeProcessor {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("规则校验");
        return ProcessResult.builder().isSuccess(true).build();
    }
}
