package com.example.base.myProcessor.context;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class ProcessContext {

    private String id;

    private String message;

    //处理器上下文核心  线程安全+防止npl
    private Map<String,Object> value = new ConcurrentHashMap<>();

}
