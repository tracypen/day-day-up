package com.hp.up.core.utils.json;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:28
 */

public class JsonBeanSerializerBuilder extends BeanSerializerBuilder {
    public JsonBeanSerializerBuilder(BeanDescription beanDesc) {
        super(beanDesc);
    }

    public JsonBeanSerializerBuilder(BeanSerializerBuilder src) {
        super(src);
    }

    @Override
    public JsonSerializer<?> build() {
        BeanPropertyWriter[] properties;
        if(this._properties != null && !this._properties.isEmpty()) {
            properties = (BeanPropertyWriter[])this._properties.toArray(new BeanPropertyWriter[this._properties.size()]);
        } else {
            if(this._anyGetter == null && this._objectIdWriter == null) {
                return null;
            }

            properties = new BeanPropertyWriter[0];
        }

        return new JsonBeanSerializer(this._beanDesc.getType(), this, properties, this._filteredProperties);
    }
}
