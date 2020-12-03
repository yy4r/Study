package com.example.base.myProcessor.context;

import com.example.base.myProcessor.Processor;
import com.example.base.myProcessor.ProcessorExcutor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class RegistryContext {
    private Map<ProcessorExcutor, Processor> processorExcutors;
}
