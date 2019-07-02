package com.mwp.demo.api.MyCache;

import java.util.List;

/**
 * 暴露给外部使用的本地缓存接口
 */
public interface LocalCacheApi {

    /**
     * 根据key获取缓存
     * @param key
     * @return
     */
    public <T> T getCache(Object key);

    /**
     * 设置缓存key
     * @param key
     * @param value
     */
    public boolean setCache(Object key,Object value);

    /**
     * 设置缓存key，带过期时间
     * @param key
     * @param value
     * @param milliSecond
     */
    public boolean setCacheExpire(Object key,Object value,Long milliSecond);

    /**
     * 按key移除缓存
     * @param key
     */
    public boolean removeCache(Object key);

    /**
     * 移除所有key
     */
    public void removeAllCache();

    /**
     * 缓存中是否包含key
     * @param key
     * @return
     */
    public boolean containKey(Object key);

    /**
     * 获取缓存大小
     */
    public int getSize();
}
