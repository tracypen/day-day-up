package com.hp.up.core.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * com.hp.up.core.schedule
 * Created by haopeng on 2017/8/12  23:00.
 */
public class MySchedule extends QuartzJobBean {
    private  static  int count = 0;

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("开始任务调度****");
        System.out.println("*******------"+count++);

    }
}
