package com.example.base.myProcessor.node.custom.check;

import com.example.base.myProcessor.common.annotation.ProcessType;
import com.example.base.myProcessor.common.context.ProcessContext;
import com.example.base.myProcessor.common.context.ProcessResult;
import com.example.base.myProcessor.node.custom.CustomProcessNode;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ProcessType(type = "risk")
public class RiskProcessor implements CustomProcessNode {

    private String type;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getTypes().contains(type)) {
            System.out.println("风控执行器执行");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }
}
