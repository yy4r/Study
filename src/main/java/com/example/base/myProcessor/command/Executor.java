package com.example.base.myProcessor.command;

import com.example.base.myProcessor.common.context.ProcessResult;

import java.util.List;

/**
 * @author Jack
 * @date 2021/3/1 8:22 下午
 */
public interface Executor {

    /**
     * 抽象出来  command做个分发器反射调用 后续编写 todo
     * @param type
     * @param commands
     * @return
     */
    ProcessResult executor(String type, List<String> commands);
}
