package com.mwp.demo.cache;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUMap<K,V> extends LinkedHashMap<K,V> implements Serializable {

    private static final long serialVersionUID = 7209116094185102801L;

    //扩容因子
    protected static final float DEFAULT_LOAD_FACTOR = 0.8f;

    //初始缓存大小
    private static int initialCapacity;

    //最大缓存大小
    private static int maxCapacity;

    //是否可以移除旧元素
    private boolean enableRemoveOldElement=true;

    //共享锁
    private final Lock lock = new ReentrantLock();


    public LRUMap(int initialCapacity) {
        super(initialCapacity,DEFAULT_LOAD_FACTOR);
    }

    public LRUMap(int initialCapacity,int maxCapacity){
        super(initialCapacity,DEFAULT_LOAD_FACTOR,true);
        this.initialCapacity = initialCapacity;
        this.maxCapacity = maxCapacity;
    }
    /*
     * 移除最老的元素
     * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
     */
    protected boolean removeEldestElement(java.util.Map.Entry entry){
        return enableRemoveOldElement && (size() > maxCapacity);
    }

    /**
     * 获取key的值
     * @param key
     * @return
     */
    public V get(Object key){
        try {
            lock.lock();
            return super.get(key);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 设置key
     * @param key
     * @param value
     */
    public V put(K key,V value){
        try{
            lock.lock();
            return super.put(key,value);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 移除key
     */
    public V remove(Object key){
        try{
            lock.lock();
            return super.remove(key);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 清楚key
     */
    public void clear(){
        try{
            lock.lock();
            super.clear();
        }finally {
            lock.unlock();
        }
    }

    public Set<K> keySet(){
        try{
            lock.lock();
            return super.keySet();
        }finally {
            lock.unlock();
        }
    }

    public boolean isEnableRemoveOldElement(){
        return enableRemoveOldElement;
    }

    public void setEnableRemoveOldElement(boolean enableRemoveOldElement){
        this.enableRemoveOldElement = enableRemoveOldElement;
    }

    public int getInitialCapacity(){
        return initialCapacity;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public void timeCleanTask(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).run();
    }
}
