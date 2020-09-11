package org.spring.server.base.singleton;

/**
 *
 * 单例
 * 饿汉模式
 *
 * 实例已经被创建出来，没有线程安全问题
 * @author hitopei
 */
public class Singleton1 {

    private Singleton1(){}

    private final static Singleton1 instance = new Singleton1();

    public static  Singleton1 getInstance(){
        return instance;
    }
}
