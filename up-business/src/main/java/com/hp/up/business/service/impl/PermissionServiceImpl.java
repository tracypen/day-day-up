package com.hp.up.business.service.impl;

import com.google.common.collect.Sets;
import com.hp.up.business.repository.PermissionRepository;
import com.hp.up.business.service.PermissionService;
import com.hp.up.business.service.ResourceService;
import com.hp.up.business.service.RoleService;
import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.Entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:36
 */
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    ResourceService resourceService;

    @Autowired
    RoleService roleService;

    // 所有的资源
    private List<SystemResource> resourceAll = null;

    // 所有的操作权限
    private List<Permission> permissionAll = null;

    public Set<String> getStringPermissions(User user) {
       // return permissionRepository.getStringPermissions(user.getId());

        // 所有资源
        resourceAll = resourceService.getAll();
        // Set<String> permissions = redisTemplate.get(PERMISSION_BY_ID + String.valueOf(user.getId()), Set.class);
        Set<String> permissions = null;
        if (permissions == null) {
            // 所有操作权限
            permissionAll = super.getAll();

            permissions = Sets.newHashSet();
            Set<Role> roles = roleService.findRoles(user);
            if (roles == null) {
                return null;
            }
    /*        for (Role role : roles) {
                for (RoleResourcePermission rrp : role.getResourcePermissions()) {
                    SystemResource resource = getResourceById(resourceAll, rrp.getResourceId());
                    if (resource == null) {
                        continue;
                    }

                    logger.debug("resource identity is: " + resource.getIdentity());
                    String identity = getIdentity(resource);
                    if (StringUtils.isBlank(identity) || Boolean.FALSE.equals(resource.getShow())) {
                        continue;
                    }

                    for (Long permissionId : rrp.getPermissionSet()) {
                        Permission permission = getPermissionById(permissionAll, permissionId);
                        if (permission == null || Boolean.FALSE.equals(permission.getShow())) {
                            continue;
                        }
                        permissions.add(identity + ":" + permission.getPermission());
                    }
                    SecurityUtils.getSubject().getSession().setAttribute(identity.split(":")[identity.split(":").length - 1], identity);
                }
            }*/
            logger.debug("roles: " + roles.size());
        }
        logger.debug("User permission: " + permissions);
        return permissions;


    }

    public void afterPropertiesSet() throws Exception {

        super.baseRepository = permissionRepository;
    }
}
