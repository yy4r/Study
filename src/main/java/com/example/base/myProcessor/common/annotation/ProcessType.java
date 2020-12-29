package com.example.base.myProcessor.common.annotation;

import com.example.base.myProcessor.common.constant.ProcessorTypeEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface ProcessType {
    /**
     * 自定义注解 表示执行器领域type
     */
    ProcessorTypeEnum type();
}
