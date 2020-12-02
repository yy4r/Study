package com.example.base.myProcessor.node.serviceNode;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.node.Handler;
import org.springframework.stereotype.Component;

@Component
public class ServiceHandler extends Handler {
    @Override
    public void execute(ProcessContext context) {
        factory.getServiceList().parallelStream().forEach((node) -> {
            ProcessResult process = node.process(context);
            if (!process.getIsSuccess()) {
                return;
            }
        });
        if (getNext()!=null){
            getNext().execute(context);
        }
    }
}
