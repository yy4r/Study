package com.example.base.myProcessor.node.custom.check;

import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;
import com.example.base.myProcessor.common.context.ProcessContext;
import com.example.base.myProcessor.common.context.ProcessResult;
import com.example.base.myProcessor.node.custom.CustomProcessNode;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LimitProcessor implements CustomProcessNode {

    private ProcessorTypeEnum typeEnum;

    @Override
    public ProcessResult process(ProcessContext context) {
        if (context.getTypes().contains(typeEnum.getType())) {
            System.out.println("限制校验执行器执行");
        }
        return ProcessResult.builder().isSuccess(true).build();
    }
}
