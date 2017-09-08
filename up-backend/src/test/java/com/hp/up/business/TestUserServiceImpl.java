package com.hp.up.business;

import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author haopeng
 * @Date 2017/9/8 8:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class TestUserServiceImpl {

    @Value("#{propertiesReader['shiro.hashIterations']}")
    private int hashIterations;

    @Autowired
    UserService userService;

    @Test
    public void getUserByName(){
        User user = userService.getUserByName("mcgrady");
        Assert.assertNotNull(user);
    }

    @Test
    public void deleteUser(){
        int result = userService.deleteUser(4L);
        System.out.println(result);
    }

    @Test
    public void password(){

        System.out.println(hashIterations);

        String password =  new SimpleHash("md5","111111", ByteSource.Util.bytes("123456"),1).toHex();

        System.out.println(password);
    }


}
