package org.spring.design.pattern.observer;

public class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("octal state = " + subject.getState());
    }
}
