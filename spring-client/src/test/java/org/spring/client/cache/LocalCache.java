package org.spring.client.cache;

import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 本地cache的事例代码
 * @author hitopei
 */
public class LocalCache {

    private static final int DEFAULT_MAX_NUMBER  =  100;

    private final Map<String, Value> cacheMap;

    private final int maxNumber;

    private static final AtomicInteger cur  = new AtomicInteger(0);


    public LocalCache(){
        this(DEFAULT_MAX_NUMBER);
    }

    public LocalCache(int maxNumber){
        this.maxNumber = maxNumber;
        this.cacheMap = new ConcurrentHashMap<>();
    }

    public boolean put(String key, Object value, long expire){
        if(StringUtils.isEmpty(key) || value == null | expire < 0){
            return false;
        }

        if(!incr()){
            return false;
        }

        if(isOver()){
            expiredAll();
            if(isOver()){
                decr();
                return false;
            }
        }

        putValue(key, value, expire);
        return true;
    }

    public Object get(String key){
        Value value = cacheMap.get(key);
        if(value == null){
            return null;
        }

        if(isExpired(value)){
            removeValue(key);
            decr();
            return null;
        }
        return value.value;
    }

    /**
     * 判断value是否过期
     * @param value
     * @return
     */
    private boolean isExpired(Value value){
        long current = System.currentTimeMillis();
        return current - value.updateTime > value.expire;
    }

    private void expiredAll(){
        for(Map.Entry<String, Value> entry : cacheMap.entrySet()){
            if(isExpired(entry.getValue())){
                removeValue(entry.getKey());
            }
        }
    }

    private void putValue(String key, Object value, long expire){
        Value v = new Value(System.currentTimeMillis(), expire, value);
        if (cacheMap.put(key, v) != null) {
            decr();
        }
    }


    private void removeValue(String key){
        if(cacheMap.remove(key) != null){
            decr();
        }
    }

    private boolean isOver(){
        return cur.get() > maxNumber;
    }

    private void decr(){
        for(; ; ){
            int c = cur.get();
            if(c == 0){
                return ;
            }

            if(cur.compareAndSet(c, --c)){
                return;
            }
        }
    }

    private boolean incr(){
        int c = cur.get();
        return cur.compareAndSet(c, ++c);
    }

    @AllArgsConstructor
    private static class Value{
        private long updateTime;

        private long expire;

        private Object value;
    }

}
