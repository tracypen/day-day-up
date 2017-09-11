package com.hp.up.business.service;

import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.User;

import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:36
 */
public interface PermissionService extends BaseService<Permission>{

    public Set<String> getStringPermissions(User user);

}

