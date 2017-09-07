package com.hp.up.core.utils.json;

import com.fasterxml.jackson.core.JsonGenerationException;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:27
 */
public class JsonMapperException extends JsonGenerationException {
    private static final long serialVersionUID = 5868593171195099592L;

    public JsonMapperException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

    public JsonMapperException(String msg) {
        super(msg);
    }

    public JsonMapperException(Throwable rootCause) {
        super(rootCause);
    }
}
