package org.spring.design.pattern.observer;

/**
 * @author hitopei
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("binary state = " + subject.getState());
    }
}
