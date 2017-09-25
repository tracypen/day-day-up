package com.hp.up.business.service;

import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:03
 */
public interface RoleService extends BaseService<Role>{

    /**
     * 获取某一用户的所有权限
     */

   public Set<String> getUserRoles(User user);

   public List<Role> getRolesByids(String ids);

    Set<Role> findRoles(User user);

    public List<Map<String, Object>> getResourceTree(Long roleId);

    int updatRoleResourPermission(final Long roleId, final String resourceId);

}
