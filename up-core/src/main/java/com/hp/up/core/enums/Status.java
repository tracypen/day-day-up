package com.hp.up.core.enums;

import com.hp.up.core.mapper.MessageMapper;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:01
 */
public interface Status {

    MessageMapper messageMapper = MessageMapper.getInstance();

    Integer getCode();

    String getReason();
}
