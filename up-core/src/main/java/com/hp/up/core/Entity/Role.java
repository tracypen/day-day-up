package com.hp.up.core.Entity;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.hp.up.core.utils.ZTree.ZTree;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Role role1 = (Role) o;

        if (name != null ? !name.equals(role1.name) : role1.name != null) {
            return false;
        }
        if (role != null ? !role.equals(role1.role) : role1.role != null) {
            return false;
        }
        if (description != null ? !description.equals(role1.description) : role1.description != null) {
            return false;
        }
        if (show != null ? !show.equals(role1.show) : role1.show != null) {
            return false;
        }
        if (typeName != null ? !typeName.equals(role1.typeName) : role1.typeName != null) {
            return false;
        }
        if (parent_id != null ? !parent_id.equals(role1.parent_id) : role1.parent_id != null) {
            return false;
        }
        return (parent_ids != null ? parent_ids.equals(role1.parent_ids) : role1.parent_ids == null) && (resourcePermissions != null ? resourcePermissions.equals(role1.resourcePermissions) : role1.resourcePermissions == null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (show != null ? show.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (parent_id != null ? parent_id.hashCode() : 0);
        result = 31 * result + (parent_ids != null ? parent_ids.hashCode() : 0);
        result = 31 * result + (resourcePermissions != null ? resourcePermissions.hashCode() : 0);
        return result;
    }

    //public static List<ZTree> getZTreeList(List<Role> roleList) {
    //
    //    List<ZTree> zTrees = Lists.newArrayList();
    //    if (null != roleList) {
    //        for (Role role : roleList) {
    //            if (null != role) {
    //                ZTree zTree = new ZTree();
    //                zTree.setId(role.getId());
    //                zTree.setpId(role.getParent_id());
    //                zTree.setName(role.getName());
    //                zTrees.add(zTree);
    //            }
    //        }
    //    }
    //    return zTrees;
    //}




}
