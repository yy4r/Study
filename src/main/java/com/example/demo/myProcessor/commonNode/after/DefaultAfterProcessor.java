package com.example.demo.myProcessor.commonNode.after;

import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;
import org.springframework.stereotype.Component;

@Component
public class DefaultAfterProcessor implements AfterProcessor {
    @Override
    public ProcessResult process(ProcessContext context) {
        System.out.println("后置处理器");
        return new ProcessResult<>(true);
    }
}
