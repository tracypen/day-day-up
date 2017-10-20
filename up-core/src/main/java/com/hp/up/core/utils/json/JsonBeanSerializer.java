package com.hp.up.core.utils.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:28
 */

public class JsonBeanSerializer extends BeanSerializer {
    public JsonBeanSerializer(BeanSerializerBase src, ObjectIdWriter objectIdWriter, Object filterId) {
        super(src, objectIdWriter, filterId);
    }

    public JsonBeanSerializer(BeanSerializerBase src, ObjectIdWriter objectIdWriter) {
        super(src, objectIdWriter);
    }

    public JsonBeanSerializer(BeanSerializerBase src, String[] toIgnore) {
        super(src, toIgnore);
    }

    public JsonBeanSerializer(BeanSerializerBase src) {
        super(src);
    }

    public JsonBeanSerializer(JavaType type, BeanSerializerBuilder builder, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties) {
        super(type, builder, properties, filteredProperties);
    }

    @Override
    protected void serializeFields(Object bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        super.serializeFields(bean, jgen, provider);

        try {
            this.validation(bean, jgen, provider);
        } catch (Exception var5) {
            throw new JsonMapperException(var5.getMessage());
        }
    }

    private void validation(Object bean, JsonGenerator jgen, SerializerProvider provider) throws JsonMapperException {
        BeanPropertyWriter[] props;
        if(this._filteredProps != null && provider.getActiveView() != null) {
            props = this._filteredProps;
        } else {
            props = this._props;
        }

        Method method = null;
        Field field = null;
        Object value = null;

        for(int i = 0; i < props.length; ++i) {
            BeanPropertyWriter prop = props[i];
            if(prop != null) {
                method = (Method)prop.getMember().getMember();

                try {
                    value = method.invoke(bean, (Object[])null);
                    field = ReflectUtils.getFieldByGetMethod(bean.getClass(), method);
                    if(field.getAnnotation(NotNull.class) != null && value == null) {
                        throw new JsonMapperException(prop.getName() + " is not null.");
                    }
                } catch (IllegalAccessException | IllegalArgumentException var11) {
                    var11.printStackTrace();
                } catch (InvocationTargetException var13) {
                    var13.printStackTrace();
                } catch (NoSuchFieldException var14) {
                    System.out.println(var14.getMessage());
                }
            }
        }

    }
}
