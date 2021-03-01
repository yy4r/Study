package com.example.base.myProcessor.srcipt.state;

import lombok.Data;

@Data
public class StateNode {

    /**
     * 状态名称
     */
    private String state;

    /**
     * 标签名称
     */
    private String lab;

    /**
     * 当前状态是否允许执行更新(Y:允许,N:不允许)
     */
    private String canUpdate = "N";

}
