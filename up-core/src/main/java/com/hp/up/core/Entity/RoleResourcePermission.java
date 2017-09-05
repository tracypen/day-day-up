package com.hp.up.core.Entity;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * 角色、资源、权限关系实体 tb_role_resource_permission
 * @Author haopeng
 * @Date 2017/9/5 16:41
 */
public class RoleResourcePermission extends IdEntity{

    private static final long serialVersionUID = 7542773244171623894L;

    private Role role;

    private Long resourceId;

    private String permissionIds;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }

    public Set<Long> getPermissionSet() {
        Set<Long> result = Sets.newHashSet();
        try {
            if (StringUtils.isNotBlank(this.permissionIds)) {
                String[] permIds = StringUtils.split(permissionIds, ",");
                if (permIds != null && permIds.length > 0) {
                    for (String permid : permIds) {
                        result.add(Long.parseLong(permid));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

