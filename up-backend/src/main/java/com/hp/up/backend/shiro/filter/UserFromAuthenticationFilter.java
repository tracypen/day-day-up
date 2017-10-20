package com.hp.up.backend.shiro.filter;

import com.hp.up.business.service.UserService;
import com.hp.up.core.common.Constants;
import com.hp.up.core.utils.date.DateUtils;
import com.hp.up.core.web.shiro.UserShiro;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 表单过滤器--认证用户信息
 * Created by haopeng on 2017/9/3  20:24.
 */
public class UserFromAuthenticationFilter extends FormAuthenticationFilter {

    private static final String DEFAULT_CAPTCHA_PARAM = "validateCode";

    private static Logger logger = LoggerFactory.getLogger(UserFromAuthenticationFilter.class);

    @Autowired
    private UserService userService;

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //在这里进行验证码的校验
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        //取出session中的正确验证码
        String validateCode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        //取出页面的验证码
        String randomcode = httpServletRequest.getParameter(DEFAULT_CAPTCHA_PARAM);
        if (randomcode != null && validateCode != null && !randomcode.equalsIgnoreCase(validateCode)) {
            //如果校验失败，将验证码错误的失败信息，通过shiroLoginFailure设置到request中
            httpServletRequest.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, "randomCodeError");
            logger.info(Constants.LOGPREFIX + "验证码错误！");
            //拒绝访问，不再校验账号和密码
            return true;
        }
        return super.onAccessDenied(request, response);
    }

    /**
     * 登录成功后执行
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
                                     ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(Constants.CURRENT_USER,subject.getPrincipal());

        //更新用户最后登录时间

        UserShiro userShiro = (UserShiro) subject.getPrincipal();

        session.setAttribute(Constants.CURRENT_USER,userShiro);

        userService.updateLastLoginTime(userShiro.getId());

        logger.info(Constants.LOGPREFIX + DateUtils.convert2String(new Date(), DateUtils.LONG_FORMAT) + userShiro.getName() + "  login success !");

        // SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);

        return super.onLoginSuccess(token, subject, request, response);
    }

}
