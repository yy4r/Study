package com.example.base.myProcessor.srcipt.task;

import com.example.base.myProcessor.srcipt.state.StateEngine;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Task {
    /**
     * 任务类型
     */
    private String type;

    /**
     * 状态机
     */
    private Map<String, StateEngine> stateEngineMap = new HashMap<>();
}
