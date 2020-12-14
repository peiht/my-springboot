package com.diy.spring.annotation;

import java.lang.annotation.*;

/**
 * @author ty
 * 自定义service注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XService {
    String value() default "";
}
