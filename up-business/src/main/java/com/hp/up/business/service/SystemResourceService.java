package com.hp.up.business.service;

import com.hp.up.core.Entity.Menu;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.Entity.User;

import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/5 17:35
 */
public interface SystemResourceService extends BaseService<SystemResource>{

    String getIdentity(SystemResource resource);

    public List<Menu> findMenus(User user);

    public SystemResource getById(Long id) ;

}
