package com.example.base.myProcessor.srcipt.state;


import com.example.base.myProcessor.common.context.ProcessResult;

public interface StateTransferAction {

    /**
     * 状态转移
     *
     * @param context
     */
    ProcessResult execute(StateTransferContext context);

}
