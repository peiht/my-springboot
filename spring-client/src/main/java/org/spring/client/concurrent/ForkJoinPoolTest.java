package org.spring.client.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author hitopei
 *
 * forkjoin method test
 */
public class ForkJoinPoolTest extends RecursiveTask<Integer> {

    private final int n;
    public ForkJoinPoolTest(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return 1;
        }

        ForkJoinPoolTest forkJoinPoolTest = new ForkJoinPoolTest(n - 1);
        forkJoinPoolTest.fork();
        ForkJoinPoolTest forkJoinPoolTest1 = new ForkJoinPoolTest(n - 2);
        return forkJoinPoolTest1.compute() + forkJoinPoolTest.join();
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        ForkJoinPoolTest forkJoinPoolTest = new ForkJoinPoolTest(30);
        Integer result = forkJoinPool.invoke(forkJoinPoolTest);
        System.out.println(result);
    }
}
