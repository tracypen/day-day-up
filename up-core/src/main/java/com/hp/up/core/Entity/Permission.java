package com.hp.up.core.Entity;

/**
 * 权限实体 t_permission
 * Created by haopeng on 2017/9/5 16:41
 */
public class Permission extends IdEntity {

    private static final long serialVersionUID = -7110720775556600326L;

    private String name;// 前端显示

    private String permission; // 系统中验证使用的权限标识

    private String description;

    private Boolean show = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
}
