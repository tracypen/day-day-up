package com.hp.up.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 体统日志注解
 * @Author haopeng
 * @Date 2017/9/27 9:30
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    //模块
    String module() default "";

    //描述
    String description() default "";
}


