package com.example.base.myProcessor;

import com.example.base.myProcessor.common.context.ProcessResult;
import com.example.base.myProcessor.common.context.ProcessContext;

public interface Processor {
    /**执行器考虑双重检查 内部做一重检查*/
    ProcessResult process(ProcessContext context);
}
