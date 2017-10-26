package com.hp.up.business.service;

import com.hp.up.core.Entity.MailEntity;
import com.hp.up.core.Entity.User;

/**
 * Created by haopeng on 2017/10/26 9:16
 */
public interface MailService {

    public void sendEmail(User obj,MailEntity mailEntity);
}
