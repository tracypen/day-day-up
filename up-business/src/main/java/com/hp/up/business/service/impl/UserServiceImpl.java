package com.hp.up.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.io.ByteSource;
import com.hp.up.business.repository.UserRepository;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
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

    //配置密码散列次数
    @Value("#{propertiesReader['shiro.hashIterations']}")
    private int hashIterations;

    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String userName) {
        return userRepository.findUserByName(userName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int remove(Long id) {
        if (null == id || id <= 0) {
            logger.error("");
            throw new IllegalArgumentException();
        }

        //删除用户角色关联表记录
        //  authRepository.removeUser(id);

        return userRepository.remove(id);
    }

    public PagingList<User> getUserPage(PageDto pageDto) {

        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());

        List<User> userLiset = this.getAll();

        PageInfo<User> pageInfo = new PageInfo<User>(userLiset);

        return new PagingList<User>(userLiset,pageInfo);
    }


    public int save(User user){
        //通过UUID作为用户密码盐值
        /*String salt = PwdUtil.getUUID();
        user.setSalt(salt);
        user.setPassword(PwdUtil.encrypt(user.getPassword(),salt,hashIterations));*/
        int count = baseRepository.save(user);
        return count;

    }



    public int updateLastLoginTime(Long id) {
        return userRepository.updateLastLoginTime(id);
    }

    public void afterPropertiesSet() throws Exception {
        super.baseRepository = userRepository;
    }






}
