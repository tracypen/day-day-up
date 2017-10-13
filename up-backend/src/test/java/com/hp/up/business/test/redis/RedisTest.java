package com.hp.up.business.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.config.CacheManagementConfigUtils;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * com.hp.up.business.test.redis
 * Created by haopeng on 2017/9/17  18:27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testTemple() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("spring-data-redis::test", "tom", 1000, TimeUnit.SECONDS);

        System.out.println("set successed");
        ValueOperations valueOpers = redisTemplate.opsForValue();
        System.out.println("get:" + valueOpers.get("spring-data-redis::test"));
//        ListOperations listOperations = redisTemplate.opsForList();
//        //listOperations.leftPush("hao::list",111);
//        //listOperations.leftPush("hao::list",222);
//        //listOperations.leftPush("hao::list",333);
//        //listOperations.leftPush("hao::list",444);
//        //listOperations.leftPush("hao::list",555);
//        //listOperations.leftPush("hao::list",666);
//        //listOperations.leftPush("hao::list",777);
//        Object o = listOperations.leftPop("hao::list");
      //  System.out.println(o.toString());
       // redisTemplate.delete("key");
    }

    @Test
    public void testRedisTemple() {
        ValueOperations valueOpers = redisTemplate.opsForValue();
        System.out.println("get:" + valueOpers.get("spring-data-redis::test"));

    }

}
