package com.hp.up.core.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * com.hp.up.core.schedule
 * Created by haopeng on 2017/8/12  23:00.
 */
public class MySchedule extends QuartzJobBean {
    private static Logger logger = LoggerFactory.getLogger(MySchedule.class);
    private  static  int count = 0;

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

       logger.info("Quartz 任务调度***"+count++);

    }
}
