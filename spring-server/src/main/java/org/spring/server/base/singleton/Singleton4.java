package org.spring.server.base.singleton;

/**
 *
 * 单例
 * double-check
 * @author hitopei
 */
public class Singleton4 {
    //保证实例的多线程可见性
    private static volatile Singleton4 instance;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    return new Singleton4();
                }
            }
        }
        return instance;
    }
}
