package com.example.base.myProcessor.node.customNode.custom;

import com.example.base.myProcessor.annotation.NodeType;
import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.node.customNode.CustomProcessNode;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@NodeType(type = "risk")
public class RiskProcessor implements CustomProcessNode {

    private String type;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getTypes().contains(type)) {
            System.out.println("风控执行器执行");
        }
        return new ProcessResult(true);
    }
}
