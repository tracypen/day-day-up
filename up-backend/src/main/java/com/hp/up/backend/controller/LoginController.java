package com.hp.up.backend.controller;

import com.hp.up.backend.shiro.Exception.ShiroException;
import com.hp.up.backend.shiro.UserShiro;
import com.hp.up.core.common.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录controller
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) throws Exception {

        //如果登录失败从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");

        logger.info(Constants.LOGPREFIX + " 执行登录");

        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if (exceptionClassName != null) {

            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {

                throw new ShiroException("账号不存在");

            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {

                throw new ShiroException("用户名/密码错误");

            } else if ("randomCodeError".equals(exceptionClassName)) {

                throw new ShiroException("验证码错误");
            } else {
                throw new Exception();//最终在异常处理器生成未知错误
            }

        }
        //此方法不处理登录成功，shiro认证成功会自动跳转到上一个路径

        //登录失败返回到login页面
        return "admin/login";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = {"/loginPage", "/login"}, method = RequestMethod.GET)
    public String loginPage() {

        Subject subject = SecurityUtils.getSubject();

        //modify 2017/09/12 17:21 不合理 改为在登录页面进行判断，登陆之后直接跳转到主页面
        // 防止用户重复登录
     /*   if (subject != null && subject.isAuthenticated()) {
            String userName = (String) subject.getPrincipal();
            //authService.clear(userId);
            subject.logout();
            logger.info(Constants.LOGPREFIX + userName + " 用户已退出！");
        }*/
        return "admin/login";
    }


    /**
     * 登录成功
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String successPage(HttpServletRequest request,Model model) {

        Subject subject = SecurityUtils.getSubject();

        if (subject != null && subject.isAuthenticated()) {

            UserShiro userShiro = (UserShiro) subject.getPrincipal();

            model.addAttribute("userName", userShiro.getName());

            model.addAttribute("status", request.getParameter("status"));

            logger.info(Constants.LOGPREFIX + userShiro.getName() + " 访问index.jsp");
        }

       // SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);

        return "admin/index";
    }

    @RequestMapping(value = "/unAuthor", method = RequestMethod.GET)
    public String unAuthorPage(Model model) {

        Subject subject = SecurityUtils.getSubject();

        if (subject != null && subject.isAuthenticated()) {

            UserShiro userShiro = (UserShiro) subject.getPrincipal();

          //  model.addAttribute("userName", userName);

            logger.info(Constants.LOGPREFIX + userShiro.getName() + " 未授权访问被拦截");
        }

        return "error/500";
    }



    @RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
    public String welcomePage(Model model) {

        return "admin/index";
    }

}
