package com.example.base.myProcessor.command;

import java.util.List;

/**
 * @author Jack
 * @date 2021/3/1 8:22 下午
 */
public interface Executor {

    /**
     * 抽象出来  command做个分发器反射调用 后续编写 todo
     * @param name
     * @param
     * @return
     */
    void executor(String name, List<String> actions);
}
