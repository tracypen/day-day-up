package com.hp.up.business.test.mail;

import com.hp.up.business.service.MailService;
import com.hp.up.core.Entity.MailEntity;
import com.hp.up.core.Entity.User;
import com.hp.up.core.utils.date.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by haopeng on 2017/10/26 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring-context.xml")
public class MailServiceImplTest {
    @Autowired
    MailService mailService;

    @Test
    public void sendEmail() throws Exception {
        /*User user = new User();
        user.setId(741258369L);
        user.setName("Mcgrady");
        user.setBirthday(DateUtils.now());
        mailService.sendEmail(user);*/

        MailEntity mailEntity = new MailEntity("Spring Freemark 邮件发送测试！！！", "info", "18802953162@163.com","mail.txt");
        //使用原生javaMail发送邮件
        //JavaMailUtils.senMail(mailEntity);
        /**
         * 使用springMail集成freeMark发送邮件
         */
        User user = new User();
        user.setId(12456789L);
        user.setName("Mcgrady");
        user.setBirthday(DateUtils.now());
        mailService.sendEmail(user,mailEntity);


    }

}