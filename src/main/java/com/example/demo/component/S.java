package com.example.demo.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class S {

    @Autowired
    T t;

}
