package com.example.base.myProcessor.srcipt.state;

import com.example.base.myProcessor.common.utils.Assert;
import com.example.base.myProcessor.common.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class DefaultStateEngine implements StateEngine {

    private StateChart stateChart;

    /**
     * 状态映射
     */
    private Map<String, StateNode> stateMap = new HashMap<>();

    /**
     * 状态转移映射
     */
    private Map<String, List<StateTransferLink>> stateTransferMap = new HashMap<>();

    /**
     *
     */
    private String initState;

    /**
     * 终态
     */
    private Set<String> finalStates = new HashSet<>();

    public void init() throws JsonProcessingException {
        if (stateChart == null) {
            return;
        }
        Map<String, StateNode> stateMap = new HashMap<>();
        if (stateChart.getStateNodes() != null) {
            for (StateNode item : stateChart.getStateNodes()) {
                StateNode node = stateMap.put(item.getState(), item);
                Assert.isNull(node, "[状态机] 存在重复定义的节点状态:" + item.getState() + ", 详细信息为:" + JsonUtil.toJsonString(stateChart));
            }
            this.stateMap = stateMap;
        }
        Map</*from state code*/String, List<StateTransferLink>> stateTransferMap = new HashMap<>();
        if (stateChart.getStateTransferLinks() != null) {
            for (StateTransferLink item : stateChart.getStateTransferLinks()) {
                // 校验状态是否合法
                Assert.notNull(stateMap.get(item.getFromState()), "[状态机] 状态转移状态fromState:" + item.getFromState() + " 不存在,详细信息为:" + JsonUtil.toJsonString(stateChart));
                Assert.notNull(stateMap.get(item.getToState()), "[状态机] 状态转移状态toState:" + item.getToState() + " 不存在,详细信息为:" + JsonUtil.toJsonString(stateChart));
                Assert.notNull(item.getToState(), "[状态机] 状态转移状态toState不能为空, 详情信息为: " + JsonUtil.toJsonString(stateChart));
                List<StateTransferLink> links = stateTransferMap.get(item.getFromState());
                if (links == null) {
                    links = new ArrayList();
                    stateTransferMap.put(item.getFromState(), links);
                }
                links.add(item);
            }
            List<StateTransferLink> init = stateTransferMap.get(null);
            Assert.isTrue(init != null && init.size() == 1, "[状态机] 初始转移目标状态有且只能有一个, 详细信息为:" + JsonUtil.toJsonString(stateChart));
            this.initState = init.get(0).getToState();
            this.stateTransferMap = stateTransferMap;
            // 推断终态
            Set<String> finalStates = new HashSet<>();
            Set<String> repeatStateSet = new HashSet<>();
            findFinalStates(null, stateTransferMap, repeatStateSet, finalStates);
            Assert.notEmpty(finalStates, "[状态机] 状态机没有终态, 详细信息为:" + JsonUtil.toJsonString(stateChart));
            this.finalStates = finalStates;
        }
    }

    private void findFinalStates(String state, Map</*from state code*/String, List<StateTransferLink>> stateTransferMap, Set<String> repeatStateSet, Set<String> finalStates) {
        repeatStateSet.add(state);
        List<StateTransferLink> links = stateTransferMap.get(state);
        if (CollectionUtils.isEmpty(links)) {
            finalStates.add(state);
            return;
        }
        for (StateTransferLink link : links) {
            if (link != null && !repeatStateSet.contains(link.getToState())) {
                findFinalStates(link.getToState(), stateTransferMap, repeatStateSet, finalStates);
            }
        }
    }

    @Override
    public StateNode getStateNode(String state) {
        return stateMap.get(state);
    }

    @Override
    public List<StateTransferLink> pullStateTransferLink(String state) {
        return stateTransferMap.get(state);
    }

    @Override
    public StateTransferLink getStateTransferLink(String fromState, String toState) {
        List<StateTransferLink> links = stateTransferMap.get(fromState);
        if (links == null) {
            return null;
        }
        for (StateTransferLink link : links) {
            if (link.getToState().equals(toState)) {
                return link;
            }
        }
        return null;
    }

    @Override
    public String getInitState() {
        return initState;
    }

    @Override
    public Set<String> getFinalStates() {
        return finalStates;
    }

    public void setStateChart(StateChart stateChart) {
        this.stateChart = stateChart;
    }
}
