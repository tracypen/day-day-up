package com.hp.up.core.Entity;

/**
 * Created by haopeng on 2017/9/13  22:11.
 */
public class Dictionary extends IdEntity{
    private static final long serialVersionUID = -6050748200939169980L;

    private String code;

    //字典类型名称
    private String name;

    // 描述
    private String description;

    private Integer del_flag ;

    private String type_code;

    private Integer is_fixed;


    public Dictionary() {
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

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public Integer getIs_fixed() {
        return is_fixed;
    }

    public void setIs_fixed(Integer is_fixed) {
        this.is_fixed = is_fixed;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", del_flag=" + del_flag +
                ", type_code='" + type_code + '\'' +
                ", is_fixed='" + is_fixed + '\'' +
                '}';
    }
}
