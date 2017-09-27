package com.hp.up.backend.controller;

import com.hp.up.business.service.SystemLogService;
import com.hp.up.core.Entity.SystemLog;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * systemLogController
 * @Author haopeng
 * @Date 2017/9/27 15:47
 */
@Controller
@RequestMapping("/system/log")
public class SystemLogController extends BaseController<SystemLog>{
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    SystemLogService systemLogService;


    /**
     * jump to systemLog list page
     */
    @RequestMapping
    public String systemLogPage() {
        return "system/log/list";
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody String getAll(PageDto pageDto , SystemLog systemLog){

        PagingList<SystemLog> systemLogList = systemLogService.getSystemLogPage(pageDto,systemLog);

        return convert2DatatablesJson(systemLogList);
    }


}
