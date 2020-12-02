package com.example.demo.test;

import com.example.demo.myProcessor.Trigger;
import com.example.demo.myProcessor.context.MyContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessorTest {

    @Autowired
    Trigger trigger;

    @Test
    public void test() {
        MyContext context = new MyContext();
        context.setId("1");
        context.setMessage("hello 你好");
        trigger.trigger(context);
    }

}
