package com.hp.up.core.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:23
 */
public class ValidationObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = -6964724122854961768L;

    public ValidationObjectMapper() {
        this._deserializationContext = new DefaultDeserializationContext.Impl(JsonBeanDeserializerFactory.instance);
        this._serializerFactory = new JsonBeanSerializerFactory((SerializerFactoryConfig)null);
    }
}