package com.example.base.myProcessor.context;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
public class ProcessContext {

    private String id;

    private String message;

    private List<String> types;

    //处理器上下文核心  线程安全+防止npl
    private Map<String,Object> value = new ConcurrentHashMap<>();

}
