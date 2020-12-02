package com.example.base.myProcessor.node.customNode.custom;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.node.customNode.CustomProcessNode;
import org.springframework.stereotype.Component;

@Component
public class Custom01Processor implements CustomProcessNode {
    @Override
    public ProcessResult process(ProcessContext context) {
        return new ProcessResult(true);
    }
}
