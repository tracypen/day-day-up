package com.hp.up.business.service.impl;

import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import org.springframework.stereotype.Service;

/**
 * com.hp.up.business.service.impl
 * Created by haopeng on 2017/8/7  21:53.
 */
@Service
public class UserServiceImpl implements UserService {
    public User getUserByName(User user) {
        return new User(new Long(1),"admin","111111");
    }
}
