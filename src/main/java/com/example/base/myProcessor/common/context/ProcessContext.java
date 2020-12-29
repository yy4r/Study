package com.example.base.myProcessor.common.context;

import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
public class ProcessContext {

    private String id;

    private String message;

    private Set<String> types;

    private Set<String> services;

    //处理器上下文核心  线程安全+防止npl
    private Map<String,Object> value = new ConcurrentHashMap<>();

    private ProcessorTypeEnum typeEnum;

}
