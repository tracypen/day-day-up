package com.hp.up.core.enums;

/**
 * @Author haopeng
 * @Date 2017/9/5 17:19
 */
public enum  ResourceOwner implements EnumIntegerValue{

    SYSTEM_RESOURCE(0, "系统资源"),

    USER_RESOURCE(1, "用户资源");

    private final int value;

    private final String info;

    ResourceOwner(int value, String info) {
        this.value = value;
        this.info = info;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getInfo() {
        return info;
    }

    public static ResourceOwner get(int value) {
        for (ResourceOwner type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return null;
    }

}
