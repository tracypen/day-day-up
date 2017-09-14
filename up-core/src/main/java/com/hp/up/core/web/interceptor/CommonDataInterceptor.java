package com.hp.up.core.web.interceptor;

import com.hp.up.core.common.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web拦截器  初始化公共参数
 * Created by Administrator on 2017/9/4.
 */
public class CommonDataInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        request.setAttribute(Constants.CONTEXT_PATH, path);
        return super.preHandle(request, response, handler);
    }
}
