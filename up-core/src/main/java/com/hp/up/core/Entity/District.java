package com.hp.up.core.Entity;

/**
 * Created by haopeng on 2017/10/23 10:36
 */
public class District extends IdEntity {
    private static final long serialVersionUID = -6750648280939149981L;


    /**
     * 区域编码
     */
    private String code;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 父级区域编码
     */
    private String parentCode;

    /**
     * 所有父级区域编码
     */
    private String parentCodes;

    /**
     * 是否可用
     */
    private Integer is_show;

    /**
     * 是否为叶子节点
     */
    private Integer is_leaf;

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getIs_show() {
        return is_show;
    }

    public void setIs_show(Integer is_show) {
        this.is_show = is_show;
    }

    public Integer getIs_leaf() {
        return is_leaf;
    }

    public void setIs_leaf(Integer is_leaf) {
        this.is_leaf = is_leaf;
    }

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof District)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        District district = (District) o;

        if (code != null ? !code.equals(district.code) : district.code != null) {
            return false;
        }
        if (name != null ? !name.equals(district.name) : district.name != null) {
            return false;
        }
        if (parentCode != null ? !parentCode.equals(district.parentCode) : district.parentCode != null) {
            return false;
        }
        if (is_show != null ? !is_show.equals(district.is_show) : district.is_show != null) {
            return false;
        }
        return is_leaf != null ? is_leaf.equals(district.is_leaf) : district.is_leaf == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (is_show != null ? is_show.hashCode() : 0);
        result = 31 * result + (is_leaf != null ? is_leaf.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "District{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", parentCodes='" + parentCodes + '\'' +
                ", is_show=" + is_show +
                ", is_leaf=" + is_leaf +
                '}';
    }
}
