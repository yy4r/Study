package com.example.base.myProcessor;

import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.context.ProcessContext;
import com.example.base.myProcessor.node.Handler;
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

    @Autowired
    private BeforeHandler beforeHandler;

    @Autowired
    private CoustomHandler coustomHandler;

    @Autowired
    private ServiceHandler serviceHandler;

    @Autowired
    private AfterHandler afterHandler;

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
        beforeHandler.setNext(coustomHandler);
        coustomHandler.setNext(serviceHandler);
        serviceHandler.setNext(afterHandler);
        beforeHandler.execute(context);
    }

}
