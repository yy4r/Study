package com.example.base.test;

import com.example.base.myProcessor.Trigger;
import com.example.base.myProcessor.context.MyContext;
import com.example.base.myProcessor.context.ProcessContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessorTest {

    @Autowired
    Trigger trigger;

    @Test
    public void test() {
        List<String> types = new ArrayList<>();
        types.add("risk");
        types.add("limit");
        ProcessContext processContext = ProcessContext.builder().id("1").message("hello 你好").types(types).build();
        trigger.trigger(processContext);
    }

}
