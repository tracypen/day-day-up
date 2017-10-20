package com.hp.up.business.schedule;

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

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static int count = 0;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info(sdf.format(new Date()) + "执行Quartz 任务调度***" + count++);

        //1.执行一步消息任务

        //2.p2p topic 接收消息

        //3.邮件发送

        //4.dwr 推送

    }
}
