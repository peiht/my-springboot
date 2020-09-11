package org.spring.server.base.singleton;

/**
 *
 * 单例
 * 懒汉模式
 * @author hitopei
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if (instance == null) {
            instance = new Singleton2();
        }

        return instance;
    }

}
