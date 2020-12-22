package org.spring.design.pattern.observer;

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
