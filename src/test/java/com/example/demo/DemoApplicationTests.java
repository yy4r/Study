package com.example.demo;

import com.example.demo.aware.Aware;
import com.example.demo.task.Processor;
import com.example.demo.task.event.EmailEvent;
import com.example.demo.task.event.Message;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Processor processor;

    @Autowired
    Aware aware;

    @Test
    public void test() {
        processor.doing("tea");
    }

    @Test
    void pulishEmail() {
        aware.pulishEmailEvent();
    }

    @Test
    void email(){
        aware.getApplicationContext().publishEvent(new EmailEvent(new Message("你好")));

    }


}
