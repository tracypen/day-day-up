package com.hp.up.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.io.ByteSource;
import com.hp.up.business.repository.UserRepository;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import com.hp.up.core.annotation.Log;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * com.hp.up.business.service.impl
 * Created by haopeng on 2017/8/7  21:53.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String userName) {
        return userRepository.findUserByName(userName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Log(module = "系统用户管理", description = "删除用户")
    public int remove(Long id) {
        if (null == id || id <= 0) {
            logger.error("");
            throw new IllegalArgumentException();
        }

        //删除用户角色关联表记录
        //  authRepository.removeUser(id);

        return userRepository.remove(id);
    }

    public PagingList<User> getUserPage(PageDto pageDto,User user) {

        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<User> userList = userRepository.getUsers(user);

        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        return new PagingList<User>(userList,pageInfo);
    }

    @Transactional
    @Log(module = "系统用户管理", description = "新增用户")
    public int save(User user){
        int count = baseRepository.save(user);
        return count;
    }

    public int updateLastLoginTime(Long id) {
        return userRepository.updateLastLoginTime(id);
    }

    @Transactional
    @Log(module = "系统用户管理", description = "新增/修改用户")
    public int saveOrUpdateUser(User user) {
        if ((null != user.getId() && user.getId() >0)){
           User resultUser =  this.update(user);
            return null != resultUser ? 1 :0 ;
        }
      return this.save(user);
    }

    public void afterPropertiesSet() throws Exception {
        super.baseRepository = userRepository;
    }






}
