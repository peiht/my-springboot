package org.spring.server.org.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解测试用
 * @author hitopei
 *
 * RetentionPolicy有三种类型
 * SOURCE修饰的注解：修饰的注解,表示注解的信息会被编译器抛弃，不会留在class文件中，注解的信息只会留在源文件中
 * CLASS修饰的注解：表示注解的信息被保留在class文件(字节码文件)中当程序编译时，但不会被虚拟机读取在运行的时候
 * RUNTIME修饰的注解：表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时。所以它能够通过反射调用，所以正常运行时注解都是使用的这个参数
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratePrint {

    String value();
}
