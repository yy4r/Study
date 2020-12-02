package com.example.base.myProcessor.node.commonNode;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.node.Handler;
import org.springframework.stereotype.Component;

@Component
public class BeforeHandler extends Handler {
    @Override
    public void execute(ProcessContext context) {
        factory.getBeforeList().parallelStream().forEach((node) -> {
            ProcessResult process = node.process(context);
            if (!process.getIsSuccess()) {
                return;
            }
        });
        if (getNext() != null) {
            getNext().execute(context);
        }
    }
}
