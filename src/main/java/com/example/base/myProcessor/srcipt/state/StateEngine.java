package com.example.base.myProcessor.srcipt.state;

import java.util.List;
import java.util.Set;

public interface StateEngine {

    /**
     * 获取节点信息
     */
    StateNode getStateNode(String state);

    /**
     * 状态转移推断
     */
    List<StateTransferLink> pullStateTransferLink(String state);

    /**
     * 检查状态转移是否合法
     */
    StateTransferLink getStateTransferLink(String fromState, String toState);

    /**
     * 获取初始状态
     */
    String getInitState();

    /**
     * 获取终态
     */
    Set<String> getFinalStates();
}
