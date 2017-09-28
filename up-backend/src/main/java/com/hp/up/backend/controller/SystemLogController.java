package com.hp.up.backend.controller;

import com.hp.up.business.service.SystemLogService;
import com.hp.up.core.Entity.SystemLog;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
    public @ResponseBody String getAll(PageDto pageDto , SystemLog systemLog, @RequestParam(value = "start_time",required = false) String  start_time,
                                       @RequestParam(value = "end_time",required = false) String end_time){

        convertQueryDate(systemLog,start_time,end_time);
        PagingList<SystemLog> systemLogList = systemLogService.getSystemLogPage(pageDto,convertQueryDate(systemLog,start_time,end_time));

        return convert2DatatablesJson(systemLogList);
    }


    private SystemLog convertQueryDate(SystemLog systemLog,String start_time,String end_time) {
        try {
            if (StringUtils.isNotBlank(start_time)){

                systemLog.setCreateDate(sdf.parse(start_time));
            }
            if (StringUtils.isNotBlank(end_time)){

                systemLog.setModifyDate(sdf.parse(end_time));
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return systemLog;
    }

}
