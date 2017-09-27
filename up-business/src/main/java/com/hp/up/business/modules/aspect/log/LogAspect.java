package com.hp.up.business.modules.aspect.log;

import com.hp.up.core.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author haopeng
 * @Date 2017/9/27 9:36
 */
@Aspect
@Component
public class LogAspect {


    @Qualifier("systemLogServiceImpl")
    @Autowired
    private LogPoint logPoint;

    /**
     * 保存系统操作日志 -- 环绕通知
     *
     * @param joinPoint 连接点
     * @return 方法执行结果
     * @throws Throwable 调用出错
     */
    @Around(value = "@annotation(com.hp.up.core.annotation.Log)")
    public Object save(ProceedingJoinPoint joinPoint) throws Throwable {
        /**
         * 解析Log注解
         */
        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint, methodName);
        Log log = method.getAnnotation(Log.class);

        /**
         * 日志入库
         */
        if (log != null) {
            logPoint.save(joinPoint, methodName, log.module(), log.description());
        }

        /**
         * 方法执行
         */
        return joinPoint.proceed();
    }

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(ProceedingJoinPoint joinPoint, String methodName) {
        /**
         * 获取目标类的所有方法，找到当前要执行的方法
         */
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

    public LogPoint getLogPoint() {
        return logPoint;
    }

    public void setLogPoint(LogPoint logPoint) {
        this.logPoint = logPoint;
    }
}