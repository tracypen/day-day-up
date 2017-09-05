package com.hp.up.business.service;

import com.hp.up.core.Entity.SystemResource;

/**
 * @Author haopeng
 * @Date 2017/9/5 17:35
 */
public interface SystemResourceService extends BaseService<SystemResource>{

    String getIdentity(SystemResource resource);

}
