package com.example.base.myProcessor.common.context;

import com.example.base.myProcessor.node.Handler;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EventContext {

    private List<Handler> handlers;

    private String message;
}
