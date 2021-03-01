package com.example.base.myProcessor.srcipt.init;

import com.example.base.myProcessor.srcipt.factory.StateFactory;
import com.example.base.myProcessor.srcipt.state.DefaultStateEngine;
import com.example.base.myProcessor.srcipt.task.Task;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jack
 * @date 2021/3/1 11:05 上午
 */
public abstract class AbstractTaskInit implements InitializingBean {

    @Autowired
    private StateFactory stateFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        Task task = new Task();
        String taskType = getTaskType();
        task.setType(taskType);
        task.getStateEngineMap().put(taskType, buildTaskState());
        stateFactory.setTask(taskType, task);
    }

    protected abstract DefaultStateEngine buildTaskState();

    protected abstract String getTaskType();

}