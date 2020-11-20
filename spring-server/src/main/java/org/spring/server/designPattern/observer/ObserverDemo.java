package org.spring.server.designPattern.observer;

/**
 * test
 * @author hitopei
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);

        subject.setState(1);
    }
}
