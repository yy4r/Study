package com.example.base.myProcessor.node.customNode;

import com.example.base.myProcessor.Processor;

public interface CustomProcessNode extends Processor {
    String getType();
    void setType(String type);
}
