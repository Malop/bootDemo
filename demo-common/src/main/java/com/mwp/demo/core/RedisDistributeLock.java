package com.mwp.demo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

public class RedisDistributeLock {

    private static String LOCK_PREFIX = "lock_";

    private static long LOCK_EXPIRE = 1000;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis分布式锁
     * @param key key值
     * @return 是否获取到
     */
    public Boolean lock(String key){

        String lockKey = LOCK_PREFIX + key;
        return (Boolean) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection)
                    throws DataAccessException {
                long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
                Boolean acquire = redisConnection.setNX(lockKey.getBytes(),
                                                        String.valueOf(expireAt).getBytes());
                if(acquire){
                    return true;
                }else{
                    //获取锁的value即过期时间
                    byte[] value = redisConnection.get(lockKey.getBytes());
                    if (Objects.nonNull(value) && value.length > 0) {
                        long expireTime = Long.parseLong(new String(value));
                        if (expireTime < System.currentTimeMillis()) {
                            // 如果锁已经过期，获取旧值并置上新值
                            byte[] oldValue = redisConnection.getSet(lockKey.getBytes(),
                                    String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                            // 防止死锁
                            return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                        }
                    }
                }
                return false;
            }
        });
    }
}
