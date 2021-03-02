package com.example.base.myProcessor.node.custom.check;

import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;
import com.example.base.myProcessor.common.context.ProcessContext;
import com.example.base.myProcessor.common.context.ProcessResult;
import com.example.base.myProcessor.node.custom.CustomProcessNode;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RiskProcessor implements CustomProcessNode {

    private ProcessorTypeEnum typeEnum = ProcessorTypeEnum.RISK;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getTypes().contains(typeEnum.getType())) {
            System.out.println("风控执行器执行");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }
}
