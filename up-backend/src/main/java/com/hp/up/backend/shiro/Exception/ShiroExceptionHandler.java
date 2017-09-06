package com.hp.up.backend.shiro.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.hp.up.backend.shiro.Exception
 * Created by haopeng on 2017/9/3  21:36.
 */
public class ShiroExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        //输出异常
        ex.printStackTrace();
        //统一异常处理代码
        //针对系统自定义的ShiroException异常，就可以直接从异常中获取一场信息，将异常处理在错误页面展示
        //异常信息
        String message = null;
        ShiroException shiroException = null;
        //如果ex是系统自定义的异常，我们就直接取出异常信息
        if (ex instanceof ShiroException) {
            shiroException = (ShiroException) ex;
        } else {
            shiroException = new ShiroException("未知错误");
        }

        //错误信息
        message = shiroException.getMessage();

        request.setAttribute("message", message);


        try {
            //转向到错误页面
            request.getRequestDispatcher("/WEB-INF/views/error/shiroError.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView();
    }
    //前端控制器DispatcherServlet在进行HandlerMapping、
    // 调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
    //参数中的handler是最终要执行的Handler，它的真实身份是HandlerMethod
    //ex就是接受到的异常信息


}
