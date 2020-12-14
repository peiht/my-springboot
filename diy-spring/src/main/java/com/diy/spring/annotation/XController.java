package com.diy.spring.annotation;

import java.lang.annotation.*;

/**
 * @author ty
 * 自定义controller注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XController {
    String value() default "";
}
