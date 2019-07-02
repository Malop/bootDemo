package com.mwp.demo.service.impl;

import com.mwp.demo.cache.LRUMap;
import com.mwp.demo.api.MyCache.LocalCacheApi;
import com.mwp.demo.cache.LocalCacheCleanTask;
import com.mwp.demo.cache.LocalCacheElement;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service
public class LocalCacheApiImpl implements LocalCacheApi {

    private static final Timer timer = new Timer();
    private static final long DEFAULT_TIMEOUT = 60L;
    private LRUMap lruMap = new LRUMap(10);

    @Override
    public Object getCache(Object key) {
        return lruMap.get(key);
    }

    @Override
    public boolean setCache(Object key, Object value) {
        try{
            LocalCacheElement localCacheElement = new LocalCacheElement(key);
            lruMap.put(localCacheElement,value);
            timer.schedule(new LocalCacheCleanTask(key,lruMap),DEFAULT_TIMEOUT);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setCacheExpire(Object key, Object value, Long expireTime) {
        try{
            LocalCacheElement localCacheElement = new LocalCacheElement(key,expireTime);
            lruMap.put(localCacheElement,value);
            timer.schedule(new LocalCacheCleanTask(key,lruMap),expireTime);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCache(Object key) {
        try{
            LocalCacheElement localCacheElement = new LocalCacheElement(key);
            lruMap.remove(localCacheElement);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void removeAllCache() {
        try{
            lruMap.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean containKey(Object key) {
        try{
            return lruMap.containsKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getSize() {
        return lruMap.size();
    }
}
