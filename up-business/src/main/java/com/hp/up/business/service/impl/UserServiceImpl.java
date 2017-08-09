package com.hp.up.business.service.impl;

import com.hp.up.business.repository.UserRepository;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.hp.up.business.service.impl
 * Created by haopeng on 2017/8/7  21:53.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserByName(User user) {
        System.out.println(user);
        return userRepository.findUserByName(user.getName());
    }
}
