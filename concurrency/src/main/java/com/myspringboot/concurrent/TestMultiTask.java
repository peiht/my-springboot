package com.myspringboot.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * test
 * @author hitopei
 */
public class TestMultiTask {

    private final Random random = new Random();

    public void deal(){
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Task task = new Task(random.nextInt(10));
            threadPoolExecutor.submit(task);
        }

    }
    public static void main(String[] args) {
        new TestMultiTask().deal();
    }
}
