package com.example.base.myProcessor.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface ProcessType {
    /**
     * 自定义注解 表示执行器领域type
     */
    String type() default "";
}
