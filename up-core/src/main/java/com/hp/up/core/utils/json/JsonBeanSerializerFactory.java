package com.hp.up.core.utils.json;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:28
 */
public class JsonBeanSerializerFactory extends BeanSerializerFactory {
    private static final long serialVersionUID = -348006947209039595L;

    public JsonBeanSerializerFactory(SerializerFactoryConfig config) {
        super(config);
    }

    @Override
    protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beanDesc) {
        return new JsonBeanSerializerBuilder(beanDesc);
    }
}