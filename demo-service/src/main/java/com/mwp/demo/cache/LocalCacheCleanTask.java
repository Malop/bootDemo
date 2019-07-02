package com.mwp.demo.cache;

import java.util.TimerTask;

public class LocalCacheCleanTask extends TimerTask {

    private Object key;

    private LRUMap lruMap;

    public LocalCacheCleanTask(Object key,LRUMap lruMap) {
        this.key = key;
        this.lruMap = lruMap;
    }

    public void run(){
        lruMap.remove(key);
    }
}
