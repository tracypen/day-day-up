package com.hp.up.core.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/7/31.
 */
public class RedisTest {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6379;
        Jedis jedis = new Jedis(host,port,50000);
        jedis.set("name","jayce");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }

}
