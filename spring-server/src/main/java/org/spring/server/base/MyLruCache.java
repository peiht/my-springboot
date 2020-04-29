package org.spring.server.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * concurrentHashMap concurrentLinkedQueue ReadWriteLock实现LRU算法
 * LRU算法，least recently used最近最少使用
 * 博文链接 https://zhuanlan.zhihu.com/p/135936339
 * @param <K>
 * @param <V>
 */
public class MyLruCache<K, V> {

    private final int maxCapacity;
    //使用concurrentHashMap做缓存，使用concurrentLinkedQueue做key的存储
    private ConcurrentHashMap<K, V> cacheMap;
    private ConcurrentLinkedQueue<K> keyQueue;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    private ScheduledExecutorService scheduledExecutorService;

    public MyLruCache(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("参数不能小于0");
        }
        this.maxCapacity = maxCapacity;
        cacheMap = new ConcurrentHashMap<>(maxCapacity);
        keyQueue = new ConcurrentLinkedQueue<>();
    }

    public V put(K key, V value, long expiredTime){
        writeLock.lock();
        try {
            //判断是否在缓存中，如果在缓存中就将queue中的数据取出放入队尾
            if (cacheMap.contains(key)) {
                putToQueueTail(key);
                cacheMap.put(key, value);
                return value;
            }
            if (cacheMap.size() == maxCapacity){
                removeOldestKey();
            }
            //不在缓存中就放入map中，再将key放入队列尾部
            cacheMap.put(key, value);
            keyQueue.add(key);

            //增加定时任务去删除key
            if (expiredTime > 0) {
                this.removeExpiredKey(key, expiredTime);
            }
            return value;
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key){
        readLock.lock();
        try {
            //有缓存就放到队列尾部
            if (cacheMap.containsKey(key)){
                putToQueueTail(key);
                return cacheMap.get(key);
            }
            return null;
        } finally {
            readLock.unlock();
        }
    }

    public V remove(K key){
        writeLock.lock();
        try {
            if (cacheMap.containsKey(key)){
                //删除队列和map中的数据
                keyQueue.remove(key);
                return cacheMap.remove(key);
            }
            return null;
        } finally {
            writeLock.unlock();
        }
    }

    public int size() {
        return cacheMap.size();
    }

    private void putToQueueTail(K key){
        keyQueue.remove(key);
        keyQueue.add(key);
    }

    private void removeOldestKey(){
        K key = keyQueue.poll();
        if (key != null){
            keyQueue.remove(key);
        }
    }

    /**
     * 定期去删除已经过期的key
     * @param key
     * @param time
     */
    private void removeExpiredKey(K key, long time){
        scheduledExecutorService.schedule(() -> {
            cacheMap.remove(key);
            keyQueue.remove(key);
        }, time, TimeUnit.MILLISECONDS);
    }
}
