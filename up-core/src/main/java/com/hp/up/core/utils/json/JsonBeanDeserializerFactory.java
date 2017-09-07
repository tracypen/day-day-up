package com.hp.up.core.utils.json;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:23
 */
public class JsonBeanDeserializerFactory extends BeanDeserializerFactory {
    private static final long serialVersionUID = 2351431079715840821L;
    public static final JsonBeanDeserializerFactory instance = new JsonBeanDeserializerFactory(new DeserializerFactoryConfig());

    public JsonBeanDeserializerFactory(DeserializerFactoryConfig config) {
        super(config);
    }

    protected BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext ctxt, BeanDescription beanDesc) {
        return new JsonBeanDeserializerBuilder(beanDesc, ctxt.getConfig());
    }
}