package com.mwp.demo.cache;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocalCacheElement implements Serializable {

    private Object key;

    private long createTime;

    private long expireTime;

    public LocalCacheElement(){

    }

    public LocalCacheElement(Object key){
        this.key = key;
        this.createTime = System.currentTimeMillis();
    }

    public LocalCacheElement(Object key,long expireTime){
        this.key = key;
        this.createTime = System.currentTimeMillis();
        this.expireTime = expireTime;
    }

    public boolean isExpire(){
        boolean isExpired = System.currentTimeMillis() >= getCreateTime() + getExpireTime();
        return isExpired;
    }
}
