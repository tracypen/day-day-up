package com.hp.up.business.repository;

import com.hp.up.core.Entity.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:48
 */
@Component
public interface PermissionRepository extends BaseRepository<Permission>{

    List<Permission> getByResourceIds(List<?> ids);

}
