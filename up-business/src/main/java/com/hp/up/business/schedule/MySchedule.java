package com.hp.up.business.schedule;

import com.hp.up.business.service.MailService;
import com.hp.up.core.Entity.MailEntity;
import com.hp.up.core.Entity.User;
import com.hp.up.core.utils.date.DateUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Quartz 任务调度
 * @Author haopeng
 * @Date 2017/8/15 16:41
 */
@Component
public class MySchedule extends QuartzJobBean {
    private static Logger logger = LoggerFactory.getLogger(MySchedule.class);

    @Autowired
    private MailService mailService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String date = DateUtils.convert2String(new Date(), DateUtils.LONG_FORMAT);

        logger.info(date + "执行Quartz 任务调度");

        //1.执行一步消息任务

        //2.p2p topic 接收消息

        //3.邮件发送
        sendRegistedMail(date + "执行Quartz 任务调度");

        //4.dwr 推送

    }


    /**
     * 定时发送邮件
     * @param info 邮件内容
     */
    private void sendRegistedMail(String info){
        MailEntity mailEntity = new MailEntity("Spring Freemark 邮件发送测试！！！", info, "18802953162@163.com","mail.txt");
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
