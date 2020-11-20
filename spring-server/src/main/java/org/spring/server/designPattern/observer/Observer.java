package org.spring.server.designPattern.observer;

/**
 * 抽象的观察类
 * @author hitopei
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
