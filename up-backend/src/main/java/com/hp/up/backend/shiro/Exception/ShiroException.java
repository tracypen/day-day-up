package com.hp.up.backend.shiro.Exception;

/**
 * com.hp.up.backend.shiro.Exception
 * Created by haopeng on 2017/9/3  21:35.
 */
public class ShiroException extends Exception{

    //异常信息
    private String message;

    public ShiroException(String message)
    {
        super(message);
        this.message=message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
