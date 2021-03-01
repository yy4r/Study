package com.example.base.myProcessor.srcipt.factory;


import com.example.base.myProcessor.srcipt.task.Task;

/**
 * @author Jack
 * @date 2021/3/1 10:41 上午
 */
public interface StateFactory {
    void setTask(String taskType, Task task);

    Task getTask(String taskType);
}
