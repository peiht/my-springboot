package org.spring.design.pattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * 要观察的主题
 * @author hitopei
 */
public class Subject {

    List<Observer> list = new LinkedList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    private int state;

    public void attach(Observer observer){
        list.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : list){
            observer.update();
        }
    }
}
