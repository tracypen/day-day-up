package com.hp.up.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index 测试controller
 */
@Controller
@RequestMapping("/index")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

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
}
