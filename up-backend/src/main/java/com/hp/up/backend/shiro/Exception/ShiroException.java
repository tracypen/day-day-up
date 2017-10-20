package com.hp.up.backend.shiro.Exception;

import com.hp.up.core.enums.ResponseStatus;

/**
 * com.hp.up.backend.shiro.Exception
 *
 * @author haopeng
 * @date 2017/9/3  21:35
 */
public class ShiroException extends Exception{

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;




    public ShiroException(ResponseStatus responseStatus) {
        this.code = responseStatus.getCode();
        this.message = responseStatus.getReason();
    }

    public ShiroException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ShiroException(String message)
    {
        super(message);
        this.message=message;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
