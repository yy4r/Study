package com.example.demo.myProcessor;

import com.example.demo.component.T;
import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;

public interface Processor {

ProcessResult<T> process(ProcessContext context);

}
