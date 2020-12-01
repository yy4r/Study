package com.example.demo.myProcessor;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class ProcessorFactory {

    // TODO: 2020/12/1 可考虑更换成map
    private Map<String, List<Processor>> map = new ConcurrentHashMap<>();

    private List<Processor> beforeList = new ArrayList<>();

    private List<Processor> serviceList = new ArrayList<>();

    private List<Processor> afterList = new ArrayList<>();

}
