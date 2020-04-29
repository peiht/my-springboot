package org.spring.client.concurrent;

/**
 * @author hitopei
 */
public class ThreadLocalTest2 {

    //private static ThreadLocal threadLocal = new ThreadLocal();
    private static InheritableThreadLocal threadLocal = new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(1);

        System.out.println("当前线程名称:"+ Thread.currentThread().getName() + "数据为:" + threadLocal.get());

        fc();

        new Thread(() -> {
            fc();
        }).start();

        Thread.sleep(1000L);

        fc();

        /**
         * 异步线程不会修改主线程的数据
         * result
         * 当前线程名称:main数据为:1
         * 当前线程名称:main数据为:1
         * 当前线程名称:Thread-0数据为:2
         * 当前线程名称:main数据为:1
         */

    }

    private static void fc(){
        System.out.println("当前线程名称:"+ Thread.currentThread().getName() + "数据为:" + threadLocal.get());
    }
}
