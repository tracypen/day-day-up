package com.hp.up.core.Entity;

/**
 * com.hp.up.core.Entity
 * Created by haopeng on 2017/9/13  22:11.
 */
public class DictionaryType extends IdEntity{
    private static final long serialVersionUID = -6750648200939169981L;
    //字典类型编码
    private String code;

    //字典类型名称
    private String name;

    // 描述
    private String description;

    private Integer del_flag ;

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public DictionaryType() {
    }

    public DictionaryType(String id) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
