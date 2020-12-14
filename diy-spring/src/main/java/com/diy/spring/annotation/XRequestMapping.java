package com.diy.spring.annotation;

import java.lang.annotation.*;

/**
 * @author ty
 * 自定义requestmapping注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XRequestMapping {
    String value() default "";
}
