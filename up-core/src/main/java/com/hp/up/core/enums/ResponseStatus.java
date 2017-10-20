package com.hp.up.core.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.hp.up.core.mapper.MessageMapper;
import com.hp.up.core.utils.json.JsonMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Map;

/**
 * @Author haopeng
 * @Date 2017/9/7 15:55
 */
public enum ResponseStatus implements Status {

    //================================================controller相关====================================================================

    /**
     * 操作成功
     */
    OK(10001, "successful", "成功"),

    /**
     * 删除失败
     */
    FAILURE_DELETE(10002, "Delete Failure", "删除失败"),
    /**
     * 添加失败
     */
    FAILURE_ADD(10003, "Add Failure", "添加失败"),
    /**
     * 修改失败
     */
    FAILURE_UPDATE(10004, "Update Failure", "修改失败"),

    //================================================API相关====================================================================

    /**
     * 系统错误
     */
    SYSTEM_ERROR(20001, "System error"),

    /**
     * 缺失必选参数，请参考API文档
     */
    MISS_REQUIRED_PARAMETE(20002, "缺失必选参数，请参考API文档"),
    /**
     * 参数值非法
     */
    PARAMETER_VALUE_ILLEGAL(20003, "参数值非法"),
    /**
     * unknown error
     */
    UNKNOWN_ERROR(20004, "unknown error"),


    //================================================shiro相关====================================================================

    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXIST(30001,"账号不存在"),
    /**
     * 用户名/密码错误
     */
    WRONG_PWD(30002,"密码错误"),
    /**
     * 验证码错误
     */
    ERROR_VALIDATE_CODE(30003,"验证码错误"),

    /**
     * 账号已锁定
     */
    ACCOUNT_LOCKED(30004,"账号已锁定")

    ;



    // private volatile MessageMapper messageMapper = MessageMapper.getInstance();

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getReason() {
        return this.reason;
    }

    Integer code;
    String reason;
    String description;


    ResponseStatus() {

    }

    ResponseStatus(Integer code) {
        this.code = code;
        this.reason = StringUtils.EMPTY;
    }

    ResponseStatus(Integer code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    ResponseStatus(Integer code, String reason, String description) {
        this.code = code;
        this.reason = reason;
        this.description = description;
    }

    public static ResponseStatus getResponseStatus(int status) {
        for (ResponseStatus responseStatus : ResponseStatus.values()) {
            if (responseStatus.getCode().intValue() == status) {
                return responseStatus;
            }
        }
        return null;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public String toJson() {
        Map<String, String> map = Maps.newHashMap();
        map.put("reason", getReason());
        map.put("code", getCode() + StringUtils.EMPTY);
        map.put("description", getDescription());
        return JsonMapper.nonDefaultMapper().toJson(map);
    }
}
