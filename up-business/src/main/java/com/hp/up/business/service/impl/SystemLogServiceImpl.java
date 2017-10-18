package com.hp.up.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.up.business.modules.aspect.log.LogPoint;
import com.hp.up.business.repository.SystemLogRepository;
import com.hp.up.business.service.SystemLogService;
import com.hp.up.core.Entity.SystemLog;
import com.hp.up.core.utils.web.IPUtils;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import com.hp.up.core.web.shiro.UserShiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Author haopeng
 * @Date 2017/9/27 9:43
 */
@Service
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog> implements SystemLogService ,LogPoint {

    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    private static Logger logger = LoggerFactory.getLogger(SystemLogServiceImpl.class);

    @Autowired
    SystemLogRepository systemLogRepository;


    @Override
    public PagingList<SystemLog> getSystemLogPage(PageDto pageDto, SystemLog systemLog) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<SystemLog> systemLogList = systemLogRepository.getSystemLogs(systemLog);

        PageInfo<SystemLog> pageInfo = new PageInfo<SystemLog>(systemLogList);

        return new PagingList<SystemLog>(systemLogList,pageInfo);
}

    @Override
    @Transactional
    public void save(ProceedingJoinPoint joinPoint, String methodName, String module, String description) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        logger.info("aop切面保存系统日志！");

        Subject subject = SecurityUtils.getSubject();
        String username = "" ;

        if (subject != null && subject.isAuthenticated()) {
            UserShiro userShiro = (UserShiro)subject.getPrincipal();
            username = userShiro != null ? userShiro.getName() : null;
        }

        String ip = IPUtils.getIpAddr(request);

        SystemLog log = new SystemLog();
        log.setUsername(username);
        log.setModule(module);
        log.setDescription(description);
        log.setIp(ip);
        log.setContent(operateContent(joinPoint, methodName, ip, request));
        super.save(log);
    }



    public String operateContent(ProceedingJoinPoint joinPoint, String methodName, String ip, HttpServletRequest request) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        StringBuffer bf = new StringBuffer();
        if (params != null && params.length > 0) {
            //Enumeration<String> paraNames = request.getParameterNames();
            //while (paraNames.hasMoreElements()) {
            //    String key = paraNames.nextElement();
            //    bf.append(key).append("=");
            //    bf.append(request.getParameter(key)).append("&");
            //}
            //if (StringUtils.isBlank(bf.toString())) {
            //    bf.append(request.getQueryString());
            //}
            for (int i = 0; i < params.length; i++) {
                if (i != params.length-1){
                    bf.append(params[i] + ",");
                }else{
                    bf.append(params[i]);
                }
            }
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), ip);
        //return String.format(LOG_CONTENT, className, "", "", ip);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        super.baseRepository = systemLogRepository;

    }
}
