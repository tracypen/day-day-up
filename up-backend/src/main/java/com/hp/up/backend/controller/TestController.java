package com.hp.up.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("")
    @ResponseBody
    public  String test(){
        return  "test";
    }


    @RequestMapping("/hello")
    public  String test1(){
        return  "test";
    }
}
