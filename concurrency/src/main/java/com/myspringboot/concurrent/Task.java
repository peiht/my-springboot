package com.myspringboot.concurrent;

public class Task implements Runnable{

    public final Integer waste;
    public Task(Integer waste){
        this.waste = waste;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(waste);
            System.out.println("执行完成" + waste);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
