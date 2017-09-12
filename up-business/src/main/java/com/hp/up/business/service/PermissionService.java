package com.hp.up.business.service;

import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.User;

import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:36
 */

public interface PermissionService extends BaseService<Permission>{

    /**
     * 获取用户所有权限
     * @param user 用户
     * @return 权限集合
     */
     Set<String> getStringPermissions(User user);

}

