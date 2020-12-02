package com.example.base.myProcessor;

import com.example.base.myProcessor.context.ProcessResult;
import com.example.base.myProcessor.context.ProcessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProcessorExcutor {


    @Autowired
    private ProcessorFactory factory;


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
        // TODO: 2020/12/1 做个责任链
        factory.getBeforeList().parallelStream().forEach((node) -> {
            ProcessResult process = node.process(context);
            if (!process.getIsSuccess()) {
                return;
            }
        });
        factory.getServiceList().parallelStream().forEach((node) -> {
            ProcessResult process = node.process(context);
            if (!process.getIsSuccess()) {
                return;
            }
        });
        factory.getCustomList().parallelStream().forEach((node) -> {
            ProcessResult process = node.process(context);
            if (!process.getIsSuccess()) {
                return;
            }
        });

        factory.getAfterList().parallelStream().forEach((node) -> {
            ProcessResult process = node.process(context);
            if (!process.getIsSuccess()) {
                return;
            }
        });
    }

}
