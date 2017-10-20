package com.hp.up.business.service.impl;

import com.google.common.collect.Lists;
import com.hp.up.business.repository.PermissionRepository;
import com.hp.up.business.repository.SystemResourceRepository;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Menu;
import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.Entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:53
 */
@Service
public class SystemResourceServiceImpl extends BaseServiceImpl<SystemResource> implements SystemResourceService {

    @Autowired
    private SystemResourceRepository systemResourceRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public String getIdentity(SystemResource resource) {
        return null;
    }

    @Override
    public List<Menu> findMenus(User user) {
        return null;
    }

    @Override
    public SystemResource getById(Long id) {
        SystemResource resource = systemResourceRepository.get(id);
        if (resource != null && StringUtils.isNotBlank(resource.getPermissions())) {
            String[] ids = resource.getPermissions().split(",");
             List<Permission> permissions = permissionRepository.getByResourceIds(Lists.newArrayList(ids));
            resource.setPermissionList(permissions);
        }
        return resource;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        super.baseRepository = systemResourceRepository;
    }
}
