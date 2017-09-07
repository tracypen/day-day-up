package com.hp.up.core.utils.json;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:07
 */
public class JsonMapper {

    public JsonMapper() {
    }

    public static DefaultJsonMapper nonDefaultMapper() {
        return DefaultJsonMapper.nonDefaultMapper();
    }

    public static DefaultJsonMapper nonNullMapper() {
        return DefaultJsonMapper.nonNullMapper();
    }

    public static DefaultJsonMapper allMapper() {
        return DefaultJsonMapper.allMapper();
    }

    public static ValidationJsonMapper validationNonDefaultMapper() {
        return ValidationJsonMapper.nonDefaultMapper();
    }

    public static ValidationJsonMapper validationNonNullMapper() {
        return ValidationJsonMapper.nonNullMapper();
    }

    public static ValidationJsonMapper validationAllMapper() {
        return ValidationJsonMapper.allMapper();
    }
}
