package com.example.base.myProcessor.srcipt.task;

/**
 * @author Jack
 * @date 2021/3/1 2:33 下午
 */
public class TaskHolder {

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
