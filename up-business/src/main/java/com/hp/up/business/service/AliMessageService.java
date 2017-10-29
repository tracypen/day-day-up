package com.hp.up.business.service;

import org.springframework.beans.factory.InitializingBean;

/**
 * com.hp.up.business.service
 * Created by haopeng on 2017/10/28  10:45.
 */
public interface AliMessageService extends InitializingBean {

    public boolean sendMessage(String phoneNumber, String cdoe);
}
