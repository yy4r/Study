package com.example.base.myProcessor.event.common;

import com.example.base.myProcessor.event.EventContext;
import com.example.base.myProcessor.node.Handler;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanHandlerListener implements ApplicationListener<BeanHandlerEvent> {
    @Override
    public void onApplicationEvent(BeanHandlerEvent beanHandlerEvent) {
        /**
         * 责任链初始化
         */
        EventContext context = (EventContext) beanHandlerEvent.getSource();
        List<Handler> handlers = context.getHandlers();
        Handler cur = null;
        for (Handler handler : handlers) {
            if (cur != null) {
                cur.setNext(handler);
            }
            cur = handler;
        }
    }
}
