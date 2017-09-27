package com.hp.up.business.modules.aspect.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * apo 存入系统日志
 * @Author haopeng
 * @Date 2017/9/27 9:34
 */
public interface LogPoint {
    /**
     * @param joinPoint
     * @param methodName    方法名称
     * @param module        模块
     * @param description   描述
     */
    void save(ProceedingJoinPoint joinPoint, String methodName, String module, String description);
}