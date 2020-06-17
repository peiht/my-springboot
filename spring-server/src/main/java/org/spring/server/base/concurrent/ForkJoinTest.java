package org.spring.server.base.concurrent;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author hitopei
 * forkJoin测试
 */
public class ForkJoinTest extends RecursiveTask<Long> {

    private static final int THRESHOLD =  10000;

    private long start;
    private long end;

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i ++) {
                sum += i;
            }
        } else {
            long step = (start + end) / 100;
            List<ForkJoinTest> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i<100; i++) {
                long lastOne = pos + step;
                if (lastOne > end){
                    lastOne = end;
                }

                ForkJoinTest test = new ForkJoinTest(pos, lastOne);
                pos += step + 1;
                subTasks.add(test);
                test.fork();
            }
            for (ForkJoinTest task : subTasks) {
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(0, 200L);
        ForkJoinTask<Long> result = pool.submit(task);
        try  {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException ignored) {
            ignored.printStackTrace();
        }

    }
}
