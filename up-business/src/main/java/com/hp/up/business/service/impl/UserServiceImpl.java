package com.hp.up.business.service.impl;

import com.hp.up.business.repository.UserRepository;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public int deleteUser(Long id) {
        if (null == id || id <= 0) {
            logger.error("");
            throw new IllegalArgumentException();
        }

        //删除用户角色关联表记录
        //  authRepository.removeUser(id);

        return userRepository.remove(id);
    }


    public int updateLastLoginTime(Long id) {
        return userRepository.updateLastLoginTime(id);
    }

    public void afterPropertiesSet() throws Exception {
        super.baseRepository = userRepository;
    }
}
