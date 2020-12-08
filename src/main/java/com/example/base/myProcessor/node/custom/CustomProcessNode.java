package com.example.base.myProcessor.node.custom;

import com.example.base.myProcessor.Processor;
import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;

public interface CustomProcessNode extends Processor {
    ProcessorTypeEnum getTypeEnum();
    void setTypeEnum(ProcessorTypeEnum typeEnum);
}
