package com.hp.up.core.utils.json;

import java.io.Serializable;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:20
 */
public abstract class AbstractJsonMapper implements Serializable {
    private static final long serialVersionUID = -4331963939509111225L;

    public AbstractJsonMapper() {
    }

    protected static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
