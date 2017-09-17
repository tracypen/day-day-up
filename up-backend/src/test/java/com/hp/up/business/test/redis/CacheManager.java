package com.hp.up.business.test.redis;

import com.hp.up.core.Entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

/**
 * redis 操作简单封装
 * com.hp.up.business.test.redis
 * Created by haopeng on 2017/9/17  18:13.
 */
public class CacheManager {

    @Autowired
    RedisTemplate redisTemplate ;

    public void set(String key, Object value){
        ValueOperations valueops = redisTemplate.opsForValue();
        if(value instanceof BaseEntity){
            BaseEntity baseEntity = (BaseEntity)value;
            valueops.set(baseEntity.getId(), value);
        }
    }

    public Object get(String key){
        ValueOperations valueops = redisTemplate.opsForValue();
        Object object = valueops.get(key);
        return object;
    }


}
