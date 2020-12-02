package com.example.base.myProcessor;

import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.context.ProcessContext;

public interface Processor {
    ProcessResult process(ProcessContext context);
}
