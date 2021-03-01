package com.example.base.myProcessor.srcipt.init.task;

import com.example.base.myProcessor.srcipt.enums.MainTaskStateEnum;
import com.example.base.myProcessor.srcipt.enums.TaskTypeEnum;
import com.example.base.myProcessor.srcipt.init.AbstractTaskInit;
import com.example.base.myProcessor.srcipt.state.DefaultStateEngine;
import com.example.base.myProcessor.srcipt.state.StateChart;
import com.example.base.myProcessor.srcipt.state.StateNode;
import com.example.base.myProcessor.srcipt.state.StateTransferLink;
import org.springframework.stereotype.Component;

/**
 * @author Jack
 * @date 2021/3/1 10:52 上午
 */
@Component
public class MainTaskInit extends AbstractTaskInit {

    @Override
    protected DefaultStateEngine buildTaskState() {
        DefaultStateEngine engine = new DefaultStateEngine();
        StateChart stateChart = new StateChart();
        engine.setStateChart(stateChart);
        //设置状态头
        StateNode header = new StateNode();
        stateChart.getStateNodes().add(header);
        // 草稿
        StateNode draft = new StateNode();
        draft.setState(MainTaskStateEnum.DRAFT.getState());
        draft.setLab(MainTaskStateEnum.DRAFT.getDesc());
        draft.setCanUpdate("Y");
        stateChart.getStateNodes().add(draft);
        // 已发布
        StateNode published = new StateNode();
        draft.setState(MainTaskStateEnum.PUBLISHED.getState());
        draft.setLab(MainTaskStateEnum.PUBLISHED.getDesc());
        draft.setCanUpdate("Y");
        stateChart.getStateNodes().add(published);
        // 待提报
        StateNode notReport = new StateNode();
        draft.setState(MainTaskStateEnum.NOT_REPORT.getState());
        draft.setLab(MainTaskStateEnum.NOT_REPORT.getDesc());
        draft.setCanUpdate("Y");
        stateChart.getStateNodes().add(notReport);
        // 已提报
        StateNode reported = new StateNode();
        draft.setState(MainTaskStateEnum.REPORTED.getState());
        draft.setLab(MainTaskStateEnum.REPORTED.getDesc());
        draft.setCanUpdate("Y");
        stateChart.getStateNodes().add(reported);
        // 草稿 到 已发布
        StateTransferLink draftToPublished = new StateTransferLink();
        draftToPublished.setFromState(draft.getState());
        draftToPublished.setToState(published.getState());
        draftToPublished.setLab("发布");
        stateChart.getStateTransferLinks().add(draftToPublished);
        // 已发布 到 待提报
        StateTransferLink publishedToNotReport = new StateTransferLink();
        publishedToNotReport.setFromState(published.getState());
        publishedToNotReport.setToState(notReport.getState());
        publishedToNotReport.setLab("审核完成");
        stateChart.getStateTransferLinks().add(publishedToNotReport);
        // 待提报 到 已提报
        StateTransferLink notReportToReported = new StateTransferLink();
        notReportToReported.setFromState(notReport.getState());
        notReportToReported.setToState(reported.getState());
        notReportToReported.setLab("提报");
        stateChart.getStateTransferLinks().add(notReportToReported);
        return engine;
    }

    @Override
    protected String getTaskType() {
        return TaskTypeEnum.MAIN_TASK.getType();
    }
}
