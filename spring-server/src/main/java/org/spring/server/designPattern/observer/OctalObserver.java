package org.spring.server.designPattern.observer;

public class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("otal state = " + subject.getState());
    }
}
