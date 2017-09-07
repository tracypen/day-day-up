package com.hp.up.business.service;

import com.hp.up.core.Entity.User;

/**
 * com.hp.up.business.service
 * Created by haopeng on 2017/8/7  21:52.
 */
public interface UserService extends BaseService<User>{

    User getUserByName(String userName);

    int deleteUser(Long id);

}
