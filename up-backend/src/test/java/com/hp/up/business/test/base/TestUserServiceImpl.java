package com.hp.up.business.test.base;

import com.hp.up.backend.shiro.utils.PwdUtil;
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
       for(int i=0;i<10;i++){
           user.setName(i+"mcgrady"+1);
           user.setRealName("peng");
           user.setPassword("111111");
           user.setBirthday(new Date());
           user.setEmail(i+"245682819@163.com");
           user.setGender(1);
           user.setQq("18802953162");
           String salt = PwdUtil.getUUID();
           user.setSalt(salt);
           user.setPassword(PwdUtil.encrypt(user.getPassword(), salt, 1));
           int save = userService.save(user);
           System.out.println(save);
       }
    }

    /**
     * mybatis分页插件测试
     */
    @Test
    public void userPage() {
        PageDto pageDto = new PageDto();
        User user = new User();
        PagingList<User> userPage = userService.getUserPage(pageDto,user);
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
