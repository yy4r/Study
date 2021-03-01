package com.example.base.myProcessor.srcipt.task;

import org.springframework.stereotype.Component;

/**
 * @author Jack
 * @date 2021/3/1 2:33 下午
 */
@Component
public class TaskHolder {

    /**
     * 线程的上下文直接这里存即可
     */
    private static ThreadLocal<Task> threadLocal = new ThreadLocal();

    public static void setTask(Task task) {
        threadLocal.set(task);
    }

    public static Task getTask() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
