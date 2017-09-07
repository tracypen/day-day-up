package com.hp.up.business.test;

import com.hp.up.business.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author haopeng
 * @Date 2017/9/7 17:53
 */

public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getuerByid(){
        userService.getById(11L);
    }

}
