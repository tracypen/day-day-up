package com.hp.up.business.test.redis;

import com.hp.up.core.Entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * redis 操作简单封装
 * com.hp.up.business.test.redis
 * Created by haopeng on 2017/9/17  18:13.
 */
//@Configuration
//@EnableCaching
public class CacheManager /* extends CachingConfigurerSupport*/ {

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

    /*@Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        // Defaults
        redisConnectionFactory.setHostName("192.168.1.166");
        redisConnectionFactory.setPort(6379);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)
        return cacheManager;
    }
*/
}
