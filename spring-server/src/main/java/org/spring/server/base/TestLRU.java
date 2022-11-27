package org.spring.server.base;

import io.kubernetes.client.Exec;
import io.kubernetes.client.openapi.ApiException;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestLRU {
    public static void main(String[] args) {
        int threadNum = 10;
        int batchSize = 10;
        MyLruCache<String, Integer> myLruCache = new MyLruCache<>(batchSize * 10);

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            executorService.submit(() -> {
                for (int t = 0; t < batchSize; t++) {
                    Integer id = atomicInteger.incrementAndGet();
                    myLruCache.put("id" + id, id, 0);
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {

        }
        executorService.shutdown();
        System.out.println("the cache size is :" + myLruCache.size());
        long endTime = System.currentTimeMillis();
        System.out.println("the multi threads cost time " + (endTime - startTime));

    }
}
