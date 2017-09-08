package com.hp.up.business;

import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Author haopeng
 * @Date 2017/9/8 8:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserServiceImpl {

    @Value("#{propertiesReader['shiro.hashIterations']}")
    private int hashIterations;

    @Autowired
    UserService userService;

    /**
     * 通过用户名查询用户信息 -- 用于登录
     */
    @Test
    public void getUserByName() {
        User user = userService.getUserByName("mcgrady");
        Assert.assertNotNull(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser() {
        int result = userService.remove(4L);
        System.out.println(result);
    }

    /**
     * 新增用户
     */
    @Test
    public void save() {
        User user = new User();
        user.setName("admin1");
        user.setPassword("81255cb0dca1a5f304328a70ac85dcbd");
        user.setSalt("123456");
        user.setRealName("hao");
        user.setBirthday(new Date());
        user.setEmail("admin@163.com");
        user.setGender(2);
        user.setQq("1315774565");
        int save = userService.save(user);
        System.out.println(save);
    }

    /**
     * mybatis分页插件测试
     */
    @Test
    public void userPage() {
        PageDto pageDto = new PageDto(1, 5);
        PagingList<User> userPage = userService.getUserPage(pageDto);
        Assert.assertNotNull(userPage);
    }


    /**
     * 密码加密测试  -- 用于注册密码加密
     */
    @Test
    public void password() {

        System.out.println(hashIterations);

        String password = new SimpleHash("md5", "111111", ByteSource.Util.bytes("123456"), 1).toHex();

        System.out.println(password);
    }


}
