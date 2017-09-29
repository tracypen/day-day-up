package com.hp.up.business.service;

import com.hp.up.core.Entity.User;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;

import java.io.InputStream;
import java.util.List;

/**
 * com.hp.up.business.service
 * Created by haopeng on 2017/8/7  21:52.
 */
public interface UserService extends BaseService<User>{

    /**
     * 通过用户名查询用户 -- 用于登录
     */
    User getUserByName(String userName);

    /**
     * 分页查询用户信息
     */
    PagingList<User> getUserPage(PageDto pageDto,User user);


    /**
     * 更新用户最后登录时间
     */
    int updateLastLoginTime(Long id);

    int saveOrUpdateUser(User user);

    InputStream getInputStream() throws Exception;

}
