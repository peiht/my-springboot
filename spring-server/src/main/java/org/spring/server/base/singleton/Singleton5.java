package org.spring.server.base.singleton;

/**
 *
 * 单例
 * 内部类实现
 *
 * 线程安全
 * @author hitopei
 */
public class Singleton5 {
    private Singleton5(){}

    private static class SingletonHolder{
        private static final Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}
