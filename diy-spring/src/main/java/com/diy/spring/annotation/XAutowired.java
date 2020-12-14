package com.diy.spring.annotation;

import java.lang.annotation.*;

/**
 * @author ty
 * 自定义 Autowired
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XAutowired {
    String value() default "";
}
