package org.spring.server.base.singleton;

/**
 *
 * 懒汉线程安全的单例模式
 * 性能不好
 * @author hitopei
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){}

    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
