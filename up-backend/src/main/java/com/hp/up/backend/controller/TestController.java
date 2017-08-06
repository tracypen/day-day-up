package com.hp.up.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
@RequestMapping("/index")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("")
    @ResponseBody
    public  String test(){
        logger.debug("---------------------------------");
        return  "test";
    }


    @RequestMapping("/hello")
    public  String test1(){
        return  "/admin/admin";
    }
}
