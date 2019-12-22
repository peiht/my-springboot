package org.spring.client.concurrent;

/**
 * @author hitopei
 */
public class ThreadLocalTest {

    private static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        threadLocal.set(1);

        System.out.println("当前线程名称:"+ Thread.currentThread().getName() + "数据为:" + threadLocal.get());

        fc();

        //另启动一个线程，不包含之前线程写入的数据
        new Thread(ThreadLocalTest::fc).start();

        /**
         * result
         * 当前线程名称:main数据为:1
         * 当前线程名称:main数据为:1
         * 当前线程名称:Thread-0数据为:null
         */
    }

    private static void fc(){
        System.out.println("当前线程名称:"+ Thread.currentThread().getName() + "数据为:" + threadLocal.get());
    }
}
