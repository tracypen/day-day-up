package com.hp.up.core.utils.json;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:24
 */
public class JsonBeanDeserializerBuilder extends BeanDeserializerBuilder {
    public JsonBeanDeserializerBuilder(BeanDescription beanDesc, DeserializationConfig config) {
        super(beanDesc, config);
    }

    public JsonBeanDeserializerBuilder(BeanDeserializerBuilder src) {
        super(src);
    }

    @Override
    public JsonDeserializer<?> build() {
        Collection<SettableBeanProperty> props = this._properties.values();
        BeanPropertyMap propertyMap = new BeanPropertyMap(this._caseInsensitivePropertyComparison, props);
        propertyMap.assignIndexes();
        boolean anyViews = !this._defaultViewInclusion;
        if(!anyViews) {
            Iterator var4 = props.iterator();

            while(var4.hasNext()) {
                SettableBeanProperty prop = (SettableBeanProperty)var4.next();
                if(prop.hasViews()) {
                    anyViews = true;
                    break;
                }
            }
        }

        if(this._objectIdReader != null) {
            ObjectIdValueProperty prop = new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED);
            propertyMap = propertyMap.withProperty(prop);
        }

        return new JsonBeanDeserializer(this, this._beanDesc, propertyMap, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, anyViews);
    }
}
