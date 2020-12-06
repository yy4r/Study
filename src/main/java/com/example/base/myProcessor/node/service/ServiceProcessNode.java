package com.example.base.myProcessor.node.service;

import com.example.base.myProcessor.Processor;
import org.springframework.beans.factory.BeanNameAware;

/**
 * service接口实现 业务领域通过name判断
 */
public interface ServiceProcessNode extends Processor, BeanNameAware {
}
