package com.example.demo.myProcessor.commonNode.before;

import com.example.demo.component.T;
import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultRuleProcessor implements BeforeProcessor {
    @Override
    public ProcessResult<T> process(ProcessContext context) {
        System.out.println("规则校验");
        return new ProcessResult<>(true);
    }
}
