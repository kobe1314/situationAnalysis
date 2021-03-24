package com.situation.analysis.annotation;

import java.lang.annotation.*;

/**
 * @description: handleType
 * @author: Kobe
 * @date: 2021/3/23 下午9:37
 * @version: v1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
    int value();
}
