package com.hp.up.core.temp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;


/**
 * 树形结构--实体实现了该接口表示要实现树形结构
 * @Author haopeng
 * @Date 2017/9/7 14:39
 */
public interface Treeable<Long extends Serializable> {

    Long getId();

    void setName(String name);

    String getName();

    // 图标
    String getIcon();

    void setIcon(String icon);

    // 父路径
    Long getParentId();

    void setParentId(Long parentId);

    String getParentIds();

    void setParentIds(String parentIds);

    // 权重，用于排序，越小越排在前面
    Integer getWeight();

    void setWeight(Integer weight);

    String getUrl();

    void setUrl(String url);

    boolean isRoot();

    boolean isLeaf();

    boolean isHasChildren();

    String getRootDefaultIcon();

    String getLeafDefaultIcon();

    String getBranchDefaultIcon();

    @JsonIgnore
    void setId(Long id);
}
