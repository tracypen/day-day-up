package com.hp.up.core.Entity;

import com.hp.up.core.enums.ResourceOwner;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 系统资源实体 tb_resource
 * @Author haopeng
 * @Date 2017/9/5 17:07
 */
public class SystemResource extends IdEntity{

    private static final long serialVersionUID = -5780764823982233168L;

    // 标题
    private String name;

    // 资源标识 用于权限匹配的 如： sys:resource
    private String identity;

    // 只有菜单才拥有
    private String url;

    // 父路径
    private Long parentId;

    // 分隔符分割的父路径字符串
    private String parentIds;

    private String icon;

    private Integer weight;

    private String permissions = StringUtils.EMPTY;

    private Boolean show = Boolean.FALSE;

    private Boolean urlType = Boolean.FALSE;

    private ResourceOwner owner = ResourceOwner.SYSTEM_RESOURCE;

    private boolean hasChildren;

    private List<Permission> permissionList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Boolean getUrlType() {
        return urlType;
    }

    public void setUrlType(Boolean urlType) {
        this.urlType = urlType;
    }

    public ResourceOwner getOwner() {
        return owner;
    }

    public void setOwner(ResourceOwner owner) {
        this.owner = owner;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
