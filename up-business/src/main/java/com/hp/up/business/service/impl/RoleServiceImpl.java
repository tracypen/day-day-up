package com.hp.up.business.service.impl;

import com.google.common.collect.Sets;
import com.hp.up.business.repository.RoleRepository;
import com.hp.up.business.service.PermissionService;
import com.hp.up.business.service.RoleService;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.RoleResourcePermission;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.Entity.User;
import com.hp.up.core.annotation.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:10
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SystemResourceService systemResourceService;

    @Autowired
    private PermissionService permissionService;


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

    public List<Map<String, Object>> getResourceTree(Long roleId) {
        if (null == roleId || roleId < 1) {
            return null;
        }

        // 存放资源树
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();

        // 存放资源树子节点所拥有的操作权限
        List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();

        // 所有资源
        List<SystemResource> resources = systemResourceService.getAll();

        // 所有操作权限
        List<Permission> permission = permissionService.getAll();

        // 某个角色拥有的所有资源和权限
        List<RoleResourcePermission> roleResourcePermissions = this.roleRepository.getRoleResourcePermission(roleId);


        if (resources.size() > 0) {
            for (SystemResource resource : resources) {
                if (null != resource) {
                    Map<String, Object> resultMap = new HashMap();
                    resultMap.put("id", resource.getId().toString());
                    resultMap.put("pId", resource.getParentId().toString());
                    resultMap.put("name", resource.getName());
                    String myPermissions = resource.getPermissions();
                    // 默认展开二级节点
                    if ("0".equals(resource.getParentId().toString())) {
                        resultMap.put("open", true);
                    }
                    Boolean bool = false;
                    if (null != roleResourcePermissions) {
                        for (RoleResourcePermission ro_Re_Permission : roleResourcePermissions) {
                            if (null != ro_Re_Permission) {
                                String resourceId = ro_Re_Permission.getResourceId().toString();
                                if (resourceId.equals(resource.getId().toString())) {
                                    bool = true;
                                    break;
                                }
                            }
                        }
                    }
                    // 角色拥有的资源默认选中
                    if (bool) {
                        resultMap.put("checked", true);
                    }
                    treeList.add(resultMap);
                    if (!"".equals(myPermissions) && null != myPermissions) {
                        if (myPermissions.indexOf(",") != -1) {
                            String[] split = myPermissions.split(",");
                            for (String permission_id : split) {

                                Permission byId = getPermissionById(permission, Long.parseLong(permission_id));
                                addChildMap2childList(childList, resource, byId);

                            }
                        } else {
                            Permission permissionById = getPermissionById(permission, Long.parseLong(myPermissions));
                            addChildMap2childList(childList, resource, permissionById);
                        }
                    }
                }
            }


            if (childList.size() > 0) {
                // 将子节点和父节点拼接
                for (Map<String, Object> map : childList) {
                    Boolean bool = false;
                    String ID = map.get("ID").toString(); //权限id
                    String resourceID = map.get("id").toString().split("_")[0]; //资源id
                    if (null != roleResourcePermissions) {
                        for (RoleResourcePermission roleResourcePermission2 : roleResourcePermissions) {
                            if (null != roleResourcePermission2) {
                                String myPermissions = roleResourcePermission2.getPermissionIds();
                                String resourceId = roleResourcePermission2.getResourceId().toString();
                                if (!"".equals(myPermissions) && null != myPermissions) {
                                    if (myPermissions.indexOf(",") != -1) {
                                        String[] split = myPermissions.split(",");
                                        for (String string : split) {
                                            if (string.equals(ID) && resourceID.equals(resourceId)) {
                                                bool = true;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (myPermissions.equals(ID) && resourceID.equals(resourceId)) {
                                            bool = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // 角色拥有的资源默认选中
                    if (bool) {
                        map.put("checked", true);
                    }
                    treeList.add(map);
                }
            }

        }
        return treeList;

    }

    @Transactional
    @Log(module = "系统角色", description = "修改角色资源权限")
    public int updatRoleResourPermission(final Long roleId, final String resourcePermission) {

        if (null == roleId || roleId <= 0) {
            logger.error("roleId is empty !");
            throw new IllegalArgumentException("");
        }
        roleRepository.deleteRoleResourcePermissionByRoleId(roleId);
        if (StringUtils.isNotBlank(resourcePermission)) {
            // 首先把resourceId过滤出来
            String[] reourceIds = resourcePermission.split(",");
            Map<String, String> resourceIdMap = new HashMap<String, String>();
            for (String resourceId : reourceIds) {
                String a = resourceId.split("_")[0].toString();
                resourceIdMap.put(a, a);
            }
            try {
                for (Map.Entry<String, String> map : resourceIdMap.entrySet()) {
                    String values = "";
                    String entryKey = map.getKey();
                    for (String resourceId : reourceIds) {
                        if (resourceId.startsWith(entryKey + "_")) {
                            values += resourceId.split("_")[1] + ",";
                        }
                    }
                    values = values.substring(0, values.length() - 1);
                    roleRepository.insertRoleResourcePermission(roleId, Long.parseLong(entryKey), values);
                }
            } catch (Exception ex) {
                return 0;
            }
        }
        return 0;
    }

    public void afterPropertiesSet() throws Exception {

        super.baseRepository = roleRepository;
    }

    // 通过permissionID获取操作权限
    public Permission getPermissionById(List<Permission> permission, Long id) {
        if (id == null || permission.size() == 0) {
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

    public void addChildMap2childList(List<Map<String, Object>> childList, SystemResource resource, Permission permission) {

        if (null != permission) {
            Map<String, Object> childMap = new HashMap();
            childMap.put("id", resource.getId().toString() + "_" + permission.getId().toString());
            childMap.put("pId", resource.getId().toString());
            childMap.put("name", permission.getName());
            childMap.put("ID", permission.getId().toString());
            childList.add(childMap);
        }

    }
}
