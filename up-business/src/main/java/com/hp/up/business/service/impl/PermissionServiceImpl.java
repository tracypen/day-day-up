package com.hp.up.business.service.impl;

import com.google.common.collect.Sets;
import com.hp.up.business.repository.PermissionRepository;
import com.hp.up.business.repository.RoleRepository;
import com.hp.up.business.service.PermissionService;
import com.hp.up.business.service.RoleService;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.RoleResourcePermission;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.Entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haopeng
 * @Date 2017/9/11 17:36
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private SystemResourceService systemResourceService;

    @Autowired
    private RoleRepository roleRepository;

    // 所有的资源
    private List<SystemResource> resourceAll = null;

    // 所有的操作权限
    private List<Permission> permissionAll = null;

    @Override
    public Set<String> getStringPermissions(User user) {

        //后期优化加入缓存

        // 所有资源
        resourceAll = systemResourceService.getAll();
        // Set<String> permissions = redisTemplate.get(PERMISSION_BY_ID + String.valueOf(user.getId()), Set.class);
        Set<String> permissions = null;
        if (null != permissions) {
            // 所有操作权限
            permissionAll = super.getAll();

            permissions = Sets.newHashSet();
            Set<Role> roles = findRoles(user);
            if (roles == null) {
                return null;
            }
            for (Role role : roles) {
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
            }
            logger.debug("roles: " + roles.size());
        }
        logger.debug("User permission: " + permissions);
        return permissions;


    }

    /**
     * 通过resourceID获取资源
     * @param resource
     * @param id
     * @return
     */
    private SystemResource getResourceById(List<SystemResource> resource, Long id) {
        if (null == id || null == resource || resource.size() == 0) {
            return null;
        }
        SystemResource returnResource = null;
        for (SystemResource resources : resource) {
            if (id.longValue() == resources.getId().longValue()) {
                returnResource = resources;
                break;
            }
        }
        return returnResource;
    }


    /**
     * 获取资源标识
     * @param resource
     * @return
     */
    private String getIdentity(SystemResource resource) {
        if (resource == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(resource.getIdentity());

        boolean hasIdentity = StringUtils.isNotBlank(resource.getIdentity());

        SystemResource parent = getSystemResourceById(resource.getParentId());

        while (parent != null) {
            if (StringUtils.isNotBlank(parent.getIdentity())) {
                sb.insert(0, parent.getIdentity() + ":");
                hasIdentity = true;
            }
            parent = getSystemResourceById(parent.getParentId());
        }

        if (!hasIdentity) {
            return StringUtils.EMPTY;
        }

        int len = sb.length();
        if (len > 0 && sb.lastIndexOf(":") == len - 1) {
            sb.deleteCharAt(len - 1);
        }

        boolean hasClildren = false;
        Set<SystemResource> clildrens = getResourceByParentId(resourceAll, resource.getId());
        if (clildrens != null && clildrens.size() > 0) {
            hasClildren = true;
        }

        if (hasClildren) {
            sb.append(":*");
        }
        return sb.toString();
    }


    /**
     * 通过resourceID获取资源
     * @param id
     * @return
     */
    private SystemResource getSystemResourceById(Long id) {
        SystemResource resource = getResourceById(resourceAll, id);
        if (resource != null && StringUtils.isNotBlank(resource.getPermissions())) {
            String[] ids = resource.getPermissions().split(",");
            List<Permission> permissions = new ArrayList<Permission>();
            for (String perId : ids) {
                Permission permissionById = getPermissionById(permissionAll, Long.parseLong(perId));
                permissions.add(permissionById);
            }
            resource.setPermissionList(permissions);
        }
        return resource;
    }


    /**
     * 通过permissionID获取操作权限
     * @param permission
     * @param id
     * @return
     */
    private Permission getPermissionById(List<Permission> permission, Long id) {
        if (null == id || null == permission || permission.size() == 0) {
            return null;
        }
        Permission returnPermission = null;
        for (Permission permissions : permission) {
            if (id.longValue() == permissions.getId().longValue()) {
                returnPermission = permissions;
                break;
            }
        }
        return returnPermission;
    }

    /**
     * 通过resource parentID获取资源
     * @param resource
     * @param id
     * @return
     */
    private Set<SystemResource> getResourceByParentId(List<SystemResource> resource, Long id) {
        if (null == id || null == resource || resource.size() == 0) {
            return null;
        }
        Set<SystemResource> returnResource = new HashSet<SystemResource>();
        for (SystemResource resources : resource) {
            if (null != resources.getParentId() && id.longValue() == resources.getParentId().longValue()) {
                returnResource.add(resources);
                break;
            }
        }
        return returnResource;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        super.baseRepository = permissionRepository;
    }

    public Set<Role> findRoles(User user){
        Set<Role> resultSet = Sets.newHashSet();
        if (user != null) {
            Long userId = user.getId();

            String roleIds = roleRepository.findRoleIds(user.getId());
            List<Role> roleList = roleRepository.getRolesByids(roleIds);

            resultSet.addAll(roleList);
        }

        return resultSet;
    }
}
