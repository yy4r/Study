package com.example.base.myProcessor;

import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.node.commonNode.AfterHandler;
import com.example.base.myProcessor.node.commonNode.BeforeHandler;
import com.example.base.myProcessor.node.customNode.CoustomHandler;
import com.example.base.myProcessor.node.serviceNode.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProcessorExcutor {

    @Autowired
    private ProcessorFactory factory;

    /**
     * todo 后续processorBean工厂换成concurrnethashmap
     */
    public void addBeforeNode(Processor node) {
        factory.getBeforeList().add(node);
    }

    public void addServiceNode(Processor node) {
        factory.getServiceList().add(node);
    }

    public void addCustomNode(Processor node) {
        factory.getCustomList().add(node);
    }

    public void addAfterNode(Processor node) {
        factory.getAfterList().add(node);
    }

    public void execute(ProcessContext context) {
        /**
         * 这里冗余了 看能不能再优化，初始化时候把责任链生成可能会好一点吗？
         */
        factory.getHead().execute(context);
    }
}
