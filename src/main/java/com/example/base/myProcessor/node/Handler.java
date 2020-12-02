package com.example.base.myProcessor.node;

import com.example.base.myProcessor.ProcessorFactory;
import com.example.base.myProcessor.context.ProcessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Handler {

    @Autowired
    protected ProcessorFactory factory;

    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    //处理请求的方法
    public abstract void execute(ProcessContext context);

}
