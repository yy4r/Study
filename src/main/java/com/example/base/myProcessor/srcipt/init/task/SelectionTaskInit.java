package com.example.base.myProcessor.srcipt.init.task;

import com.example.base.myProcessor.srcipt.enums.TaskTypeEnum;
import com.example.base.myProcessor.srcipt.init.AbstractTaskInit;
import com.example.base.myProcessor.srcipt.state.DefaultStateEngine;
import org.springframework.stereotype.Component;

/**
 * @author Jack
 * @date 2021/3/1 10:54 上午
 */
@Component
public class SelectionTaskInit extends AbstractTaskInit {

    @Override
    protected DefaultStateEngine buildTaskState() {
        DefaultStateEngine engine = new DefaultStateEngine();
        // TODO: 2021/3/1  
        return engine;
    }

    @Override
    protected String getTaskType() {
        return TaskTypeEnum.SELECTION_TASK.getType();
    }
}
