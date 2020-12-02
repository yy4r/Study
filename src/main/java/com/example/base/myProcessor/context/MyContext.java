package com.example.base.myProcessor.context;

import java.util.List;
import java.util.Map;

//自定义扩展上下文
public class MyContext extends ProcessContext{
    MyContext(String id, String message, List<String> types, Map<String, Object> value) {
        super(id, message, types, value);
    }
}
