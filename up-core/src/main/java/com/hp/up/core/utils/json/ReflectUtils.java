package com.hp.up.core.utils.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:25
 */

public class ReflectUtils {
    public static final String IAE_MESSAGE = "argument type mismatch";

    public ReflectUtils() {
    }

    public static Object getFieldValue(Object result, Field field) {
        try {
            return field.get(result);
        } catch (Exception var3) {
            return null;
        }
    }

    public static Field getField(Object object, String fieldName) throws NoSuchFieldException, SecurityException {
        return object.getClass().getField(fieldName);
    }

    public static Field getFieldFromBean(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        return getFieldFromBean(clazz, fieldName, clazz);
    }

    public static Field getFieldFromBean(Class<?> clazz, String fieldName, Class<?> originalClass) throws NoSuchFieldException {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException var4) {
            if(clazz.getSuperclass() != null) {
                return getFieldFromBean(clazz.getSuperclass(), fieldName, originalClass);
            } else {
                throw new NoSuchFieldException("No such field found " + originalClass.getName() + "." + fieldName);
            }
        }
    }

    public static Object invoke(Method method, Object obj, Object... args) {
        Object result = null;

        try {
            result = method.invoke(obj, args);
        } catch (Exception var5) {
            ;
        }

        return result;
    }

    public static Field getFieldByGetMethod(Class<?> clazz, Method getMethod) throws NoSuchFieldException {
        String getMethodName = getMethod.getName();
        String fieldName = getMethodName.substring(3, 4).toLowerCase() + getMethodName.substring(4);
        return getFieldFromBean(clazz, fieldName);
    }
}
