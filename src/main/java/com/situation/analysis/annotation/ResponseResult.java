package com.situation.analysis.annotation;

import java.lang.annotation.*;

/**
 * @description: custom response
 * @author: Kobe
 * @date: 2021/2/16 下午3:57
 * @version: v1.0
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
    String value() default "";
}

