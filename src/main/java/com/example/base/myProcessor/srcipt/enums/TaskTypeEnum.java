package com.example.base.myProcessor.srcipt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jack
 * @date 2021/3/1 10:55 上午
 */
@Getter
@AllArgsConstructor
public enum TaskTypeEnum {

    MAIN_TASK("MAIN_TASK", "主任务"),
    LEADER_SUB_TASK("LEADER_SUB_TASK", "组长子任务"),
    MEMBER_SUB_TASK("MEMBER_SUB_TASK", "组员子任务"),
    SELECTION_TASK("SELECTION_TASK", "选品任务"),
    ;

    private String type;
    private String msg;
}
