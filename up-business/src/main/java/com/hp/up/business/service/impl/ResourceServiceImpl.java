package com.hp.up.business.service.impl;

import com.hp.up.business.service.ResourceService;
import com.hp.up.business.service.RoleService;
import com.hp.up.core.Entity.SystemResource;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:53
 */
public class ResourceServiceImpl extends BaseServiceImpl<SystemResource> implements ResourceService {




    public void afterPropertiesSet() throws Exception {
        super.baseRepository = null;
    }
}
