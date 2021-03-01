package com.example.base.myProcessor.srcipt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jack
 * @date 2021/3/1 11:15 上午
 */
@Getter
@AllArgsConstructor
public enum MainTaskStateEnum {
    DRAFT("DRAFT", "草稿"),
    PUBLISHED("PUBLISHED", "已发布"),
    NOT_REPORT("NOT_REPORT", "待提报"),
    REPORTED("REPORTED", "已提报"),
    ;

    private final String state;

    private final String desc;
}
