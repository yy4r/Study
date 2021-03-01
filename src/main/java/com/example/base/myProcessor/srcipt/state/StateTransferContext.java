package com.example.base.myProcessor.srcipt.state;

import lombok.Data;

@Data
public class StateTransferContext {

    /**
     * 工单id
     */
    private Long orderId;

    /**
     * 链接code
     */
    private String linkCode;

    /**
     * 源状态
     */
    private String fromState;

    /**
     * 目标状态
     */
    private String toState;

}
