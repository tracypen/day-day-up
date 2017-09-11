package com.hp.up.core.Entity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 系统角色实体 tb_role
 * @Author haopeng
 * @Date 2017/9/5 16:41
 */
public class Role extends IdEntity{

    // 前端显示名称
    private String name;

    // 系统中验证时候使用的角色标识
    private String role;

    private String description;

    // 是否显示，也表示是否可用
    private Boolean show = Boolean.FALSE;

    //  角色类型
    private String typeName;

    // 角色父节点
    private String parent_id;

    // 角色父节点字符串 0/1
    private String parent_ids;

    //（对资源操作的）权限集合
    private List<RoleResourcePermission> resourcePermissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(String parent_ids) {
        this.parent_ids = parent_ids;
    }
    public List<RoleResourcePermission> getResourcePermissions() {
        if (null == resourcePermissions){
            resourcePermissions = Lists.newArrayList();
        }
        return resourcePermissions;
    }

    public void setResourcePermissions(List<RoleResourcePermission> resourcePermissions) {
        this.resourcePermissions = resourcePermissions;
    }
}
