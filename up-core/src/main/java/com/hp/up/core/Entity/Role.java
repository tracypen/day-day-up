package com.hp.up.core.Entity;

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

    // 当前用户角色
    private Boolean currentRole;

    // 是否可修改
    private boolean enableEdit;

    //（对资源操作的）权限集合
   // private List<RoleResourcePermission> resourcePermissions;

}
