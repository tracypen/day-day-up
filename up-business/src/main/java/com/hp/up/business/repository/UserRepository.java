package com.hp.up.business.repository;

import com.hp.up.core.Entity.User;

/**
 *
 * Created by haopeng on 2017/8/7  22:24.
 */
public interface UserRepository {

    public User findUserByName(User user);
}
