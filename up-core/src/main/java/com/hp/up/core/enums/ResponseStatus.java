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
public enum ResponseStatus implements Status{

    /**
     * 删除失败
     */
    FAILURE_DELETE(10022, "Delete Failure", "删除失败"),
    /**
     * 添加失败
     */
    FAILURE_ADD(10023, "Add Failure", "添加失败"),
    /**
     * 修改失败
     */
    FAILURE_UPDATE(10024, "Update Failure", "修改失败"),

    OK(0, "successful", "成功"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(10001, "System error"),

    /**
     * 缺失必选参数，请参考API文档
     */
    MISS_REQUIRED_PARAMETE(10002, "缺失必选参数，请参考API文档"),
    /**
     * 参数值非法
     */
    PARAMETER_VALUE_ILLEGAL(10003, "参数值非法"),
    /**
     * unknown error
     */
    UNKNOWN_ERROR(10004, "unknown error"),
    ;

    public Integer getCode() {
        return null;
    }

    public String getReason() {
        return null;
    }


    Integer code;
    String reason;
    String description;

    private volatile MessageMapper messageMapper = MessageMapper.getInstance();

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
