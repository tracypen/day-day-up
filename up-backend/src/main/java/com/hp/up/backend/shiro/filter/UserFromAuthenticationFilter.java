package com.hp.up.backend.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * com.hp.up.backend.shiro.filter
 * Created by haopeng on 2017/9/3  20:24.
 */
public class UserFromAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {

        //在这里进行验证码的校验
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        //取出session中的正确验证码
        String validateCode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        //取出页面的验证码
        String randomcode = httpServletRequest.getParameter("vaildateCode");
        if (randomcode != null && validateCode != null && !randomcode.equalsIgnoreCase(validateCode)) {
            //如果校验失败，将验证码错误的失败信息，通过shiroLoginFailure设置到request中
            httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");

            //拒绝访问，不再校验账号和密码
            return true;
        }
        return super.onAccessDenied(request, response);
    }
}
