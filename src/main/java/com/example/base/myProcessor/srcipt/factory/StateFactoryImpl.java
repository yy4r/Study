package com.example.base.myProcessor.srcipt.factory;

import com.example.base.myProcessor.srcipt.task.Task;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack
 * @date 2021/3/1 10:44 上午
 */
@Component
public class StateFactoryImpl implements StateFactory {

    private Map<String, Task> map = new HashMap<>();

    @Override
    public void setTask(String taskType, Task task) {
        map.put(taskType, task);
    }

    @Override
    public Task getTask(String taskName) {
        return map.get(taskName);
    }
}
