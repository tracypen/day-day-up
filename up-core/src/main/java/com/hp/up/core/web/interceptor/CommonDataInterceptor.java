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
        request.setAttribute(Constants.CONTEXT_PATH, request.getContextPath());
        //loadRequestInfo(request);
        return super.preHandle(request, response, handler);
    }


    //private void loadRequestInfo(HttpServletRequest request) {
    //    if (request.getAttribute(Constants.CONTEXT_PATH) == null) {
    //        request.setAttribute(Constants.CONTEXT_PATH, request.getContextPath());
    //    }
    //    if (request.getAttribute(Constants.CURRENT_URL) == null) {
    //        request.setAttribute(Constants.CURRENT_URL, extractCurrentURL(request, true));
    //    }
    //    if (request.getAttribute(Constants.NO_QUERYSTRING_CURRENT_URL) == null) {
    //        request.setAttribute(Constants.NO_QUERYSTRING_CURRENT_URL, extractCurrentURL(request, false));
    //    }
    //    if (request.getAttribute(Constants.BACK_URL) == null) {
    //        request.setAttribute(Constants.BACK_URL, extractBackURL(request));
    //    }
    //    if (request.getAttribute(Constants.VERSIONS) == null) {
    //        request.setAttribute(Constants.VERSIONS, ProfileApplicationContext.versions);
    //    }
    //}
    //








}
