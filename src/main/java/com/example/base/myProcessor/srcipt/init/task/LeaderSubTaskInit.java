package com.example.base.myProcessor.srcipt.init.task;

import com.example.base.myProcessor.srcipt.enums.TaskTypeEnum;
import com.example.base.myProcessor.srcipt.init.AbstractTaskInit;
import com.example.base.myProcessor.srcipt.state.DefaultStateEngine;
import org.springframework.stereotype.Component;

/**
 * @author Jack
 * @date 2021/3/1 10:53 上午
 */
@Component
public class LeaderSubTaskInit extends AbstractTaskInit {

    @Override
    protected DefaultStateEngine buildTaskState() {
        DefaultStateEngine engine = new DefaultStateEngine();
        // TODO: 2021/3/1
        return engine;
    }

    @Override
    protected String getTaskType() {
        return TaskTypeEnum.LEADER_SUB_TASK.getType();
    }
}
