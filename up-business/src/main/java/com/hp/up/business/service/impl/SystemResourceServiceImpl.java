package com.hp.up.business.service.impl;

import com.hp.up.business.repository.SystemResourceRepository;
import com.hp.up.business.service.RoleService;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Menu;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.Entity.User;
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
    SystemResourceRepository systemResourceRepository;

    public String getIdentity(SystemResource resource) {
        return null;
    }

    public List<Menu> findMenus(User user) {
        return null;
    }


    public void afterPropertiesSet() throws Exception {
         super.baseRepository = systemResourceRepository;
    }
}
