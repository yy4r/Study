package com.example.base.myProcessor;

import com.example.base.myProcessor.context.ProcessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * todo 后续需要扩展，后续可以考虑不交给spring管理 如果修改的话 工厂需要改成静态工厂
 */
@Component
public class ProcessorExcutor {

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
         * 已优化责任链
         */
        factory.getHead().execute(context);
    }
}
