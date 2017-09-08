package com.hp.up.core.enums;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Boolean 类型枚举类
 * @Author haopeng
 * @Date 2017/9/8 15:03
 */
public enum BooleanType implements EnumIntegerValue {

    @XmlEnumValue("1")
    TRUE(1, "启用"),

    @XmlEnumValue("0")
    FALSE(0, "禁用");

    private final int value;
    private final String info;

    private BooleanType(int value, String info) {
        this.value = value;
        this.info = info;
    }

    public int getValue() {
        return value;
    }

    public String getInfo() {
        return info;
    }

    public BooleanType get(int value) {
        for (BooleanType type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return null;
    }
}

