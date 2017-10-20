package com.hp.up.core.Entity;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/12 11:11
 */
public class Menu extends IdEntity implements Serializable {
    private static final long serialVersionUID = -6050648200939169980L;

    private Long id;
    private String name;
    private String icon;
    private String url;
    private String identity;
    private List<Menu> children;

    public Menu() {
    }

    public Menu(Long id, String name, String icon, String url, String identity) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.identity = identity;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public List<Menu> getChildren() {
        if (children == null) {
            children = Lists.newArrayList();
        }
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public boolean isHasChildren() {
        return !getChildren().isEmpty();
    }

}
