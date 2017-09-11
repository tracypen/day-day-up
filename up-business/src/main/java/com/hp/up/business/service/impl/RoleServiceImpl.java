package com.hp.up.business.service.impl;

import com.google.common.collect.Sets;
import com.hp.up.business.repository.RoleRepository;
import com.hp.up.business.service.RoleService;
import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:10
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    public Set<String> getUserRoles(User user) {

        //后期添加redis缓存
        Set<String> result = Sets.newHashSet();
        String roleIds = roleRepository.findRoleIds(user.getId());

        if (StringUtils.isNotBlank(roleIds)) {
            List<Role> roleList = this.getRolesByids(roleIds);
            if (roleList != null && roleList.size() > 0) {

                for (Role role : roleList) {
                    result.add(role.getName());
                }
            }
        }
        return result;

    }

    public List<Role> getRolesByids(String ids) {
        return roleRepository.getRolesByids(ids);
    }

    public Set<Role> findRoles(User user) {
        Set<Role> resultSet = Sets.newHashSet();
        if (user != null) {
            Long userId = user.getId();

            String roleIds = roleRepository.findRoleIds(user.getId());
            List<Role> roleList = this.getRolesByids(roleIds);

            resultSet.addAll(roleList);
        }

        return resultSet;
    }


    public void afterPropertiesSet() throws Exception {

        super.baseRepository = roleRepository;
    }


}
