package com.example.demo.myProcessor;

import com.example.demo.myProcessor.context.ProcessContext;
import com.example.demo.myProcessor.context.ProcessResult;

public interface Processor {

ProcessResult process(ProcessContext context);

}
