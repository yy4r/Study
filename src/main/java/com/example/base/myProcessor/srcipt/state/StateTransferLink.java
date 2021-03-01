package com.example.base.myProcessor.srcipt.state;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StateTransferLink {

    /**
     * 编码
     */
    private String code;

    /**
     * 标签名称
     */
    private String lab;

    /**
     * 源状态
     */
    private String fromState;

    /**
     * 目标状态
     */
    private String toState;

    /**
     * 当状态转移时执行的action
     */
    private List<String> actions = new ArrayList<>();

}
