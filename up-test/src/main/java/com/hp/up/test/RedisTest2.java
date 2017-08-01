package com.hp.up.test;

import com.hp.up.entity.User;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/7/31.
 */
public class RedisTest2 {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6381;
        Jedis jedis = new Jedis(host, port);
        setString(jedis);
       // setObject(jedis);
        jedis.close();
    }

    private static void setString(Jedis jedis) {
        jedis.set("name", "jayce");
        String name = jedis.get("name");
        System.out.println(name);
    }


//    private static void setObject(Jedis jedis) {
//        User user = new User();
//        user.setId(1);
//        user.setUserName("jayce");
//        user.setPassword("kong");
//        //序列化object
//        byte[] values = SerializeUtil.serialize(user);
//        byte[] names = "user".getBytes();
//        jedis.set(names, values);
//        byte[] bytes = jedis.get("user".getBytes());
//        User userCache = (User) SerializeUtil.unserialize(bytes);
//        System.out.println(userCache);
//
//    }


//    private static void setObject(Jedis jedis) {
//        User user = new User();
//        user.setId(1);
//        user.setUserName("jayce");
//        user.setPassword("kong");
//        byte[] values = SerializeUtil.serialize(user);
//        byte[] names = "user".getBytes();
//        jedis.set(names, values);
//        byte[] bytes = jedis.get("user".getBytes());
//        User userCache = (User) SerializeUtil.unserialize(bytes);
//        System.out.println(userCache);
//
//    }

}
