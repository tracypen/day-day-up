package com.hp.up.business.schedule;

import com.hp.up.core.Entity.MailEntity;
import com.hp.up.core.Entity.User;
import com.hp.up.core.utils.date.DateUtils;
import com.hp.up.core.utils.mail.JavaMailUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Quartz 任务调度
 * @Author haopeng
 * @Date 2017/8/15 16:41
 */
public class MySchedule extends QuartzJobBean {
    private static Logger logger = LoggerFactory.getLogger(MySchedule.class);



    private static int count = 0;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String date = DateUtils.convert2String(new Date(), DateUtils.LONG_FORMAT);
        logger.info(date + "执行Quartz 任务调度" + count++);

        //1.执行一步消息任务

        //2.p2p topic 接收消息

        //3.邮件发送
        sendRegistedMail(date + "执行Quartz 任务调度" + count++);

        //4.dwr 推送

    }


    /**
     * 定时发送邮件
     * @param info 邮件内容
     */
    private void sendRegistedMail(String info){
        MailEntity mailEntity = new MailEntity("day-day-up quartz test", info, "18802953162@163.com");
        JavaMailUtils.senMail(mailEntity);

    }

}
