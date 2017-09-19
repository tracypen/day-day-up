package com.hp.up.business.test.base;

import com.hp.up.backend.shiro.utils.PwdUtil;
import com.hp.up.business.service.RoleService;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.Role;
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
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/8 8:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class RolerService {

    @Autowired
    RoleService roleService;

    @Test
    public void getAll(){
        List<Role> list = roleService.getAll();
        Assert.assertNotNull(list);
    }


}
