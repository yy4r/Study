package com.example.base.myProcessor.srcipt.state;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StateChart {

    private String version;

    /**
     * 状态节点
     */
    private List<StateNode> stateNodes = new ArrayList<>();

    /**
     * 状态转移
     */
    private List<StateTransferLink> stateTransferLinks = new ArrayList<>();
}
