package com.hp.up.core.utils.ZTree;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * ztree实体
 * @Author haopeng
 * @Date 2017/9/19 13:54
 */

public class ZTree<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2470220610691159493L;

    private Long id;
    private String pId;
    private String name;
    private String iconSkin;
    private boolean open;
    private boolean root;
    private boolean isParent;
    private boolean nocheck = false;
    private boolean preOpen;
    private boolean checked = false;

    private String description;

    private String identity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public boolean isIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

    public boolean isPreOpen() {
        return preOpen;
    }

    public void setPreOpen(boolean preOpen) {
        this.preOpen = preOpen;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "ZTree{" +
                "id=" + id +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                ", iconSkin='" + iconSkin + '\'' +
                ", open=" + open +
                ", root=" + root +
                ", isParent=" + isParent +
                ", nocheck=" + nocheck +
                ", preOpen=" + preOpen +
                ", checked=" + checked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZTree)) return false;

        ZTree<?> zTree = (ZTree<?>) o;

        if (open != zTree.open) return false;
        if (root != zTree.root) return false;
        if (isParent != zTree.isParent) return false;
        if (nocheck != zTree.nocheck) return false;
        if (preOpen != zTree.preOpen) return false;
        if (checked != zTree.checked) return false;
        if (id != null ? !id.equals(zTree.id) : zTree.id != null) return false;
        if (pId != null ? !pId.equals(zTree.pId) : zTree.pId != null) return false;
        if (name != null ? !name.equals(zTree.name) : zTree.name != null) return false;
        return iconSkin != null ? iconSkin.equals(zTree.iconSkin) : zTree.iconSkin == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (iconSkin != null ? iconSkin.hashCode() : 0);
        result = 31 * result + (open ? 1 : 0);
        result = 31 * result + (root ? 1 : 0);
        result = 31 * result + (isParent ? 1 : 0);
        result = 31 * result + (nocheck ? 1 : 0);
        result = 31 * result + (preOpen ? 1 : 0);
        result = 31 * result + (checked ? 1 : 0);
        return result;
    }
}