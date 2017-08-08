package com.hp.up.backend.controller;

import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index 测试controller
 */
@Controller
@RequestMapping("/index")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("")
    @ResponseBody
    public  String test(){
        logger.debug("debug--------");
        logger.info("info----------");
        logger.warn("warn----------");
        logger.error("error---------");
        return  "test";
    }


    @RequestMapping("/hello")
    public  String test1(){
        return  "/admin/admin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(User user, ModelMap map){
        User userEntity = userService.getUserByName(new User());
        if (userEntity != user){
            map.addAttribute("user",userEntity);
            return  "/admin/admin";
        }
     return  "/admin/index";
    }



}
