package com.hp.up.backend.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.BaseEntity;
import com.hp.up.core.Entity.IdEntity;
import com.hp.up.core.Entity.User;
import com.hp.up.core.common.Constants;
import com.hp.up.core.utils.web.RenderUtils;
import com.hp.up.core.web.page.PagingList;
import com.hp.up.core.web.shiro.UserShiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Controller 基类
 *
 * @Author haopeng
 * @Date 2017/9/7 15:22
 */
public class BaseController <E extends Serializable> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private final String RESPONSE_ENTITY_JSON_TYPE = MediaType.APPLICATION_JSON_VALUE + "; charset=" + Constants.ENCODING_UTF8;

    private final String RESPONSE_ENTITY_TEXT_TYPE = MediaType.TEXT_HTML_VALUE + "; charset=" + Constants.ENCODING_UTF8;

    private String viewPrefix;


    @Autowired
    UserService userService;


    public BaseController() {

    }

    /**
     * 获取当前用户
     * @return
     */
    public User getCurrentUser() {

        Subject subject = SecurityUtils.getSubject();

        UserShiro userShiro = (UserShiro) subject.getPrincipal();

        User currentUser = userService.getUserByName(userShiro.getName());

        return currentUser;
    }

    protected String viewName(String suffixName) {
        if (!suffixName.startsWith("/")) {
            suffixName = "/" + suffixName;
        }
        return getViewPrefix() + suffixName;
    }

    public String getViewPrefix() {
        return viewPrefix;
    }


    protected <T> ResponseEntity<T> getJsonResponseEntity(Object obj) {
        if (obj != null) {
            return RenderUtils.getJsonResponseEntity(obj);
        }
        return null;
    }

        protected String convert2DatatablesJson(PagingList<E> pageList){
        Map<String, Object> map = Maps.newHashMap();
        if (null != pageList && null != pageList.getPaging()){
            map.put("iTotalRecords", pageList.getPaging().getTotal());
            map.put("iTotalDisplayRecords", pageList.getPaging().getTotal());
        }
        map.put("aaData", pageList.getData());
        return JSON.toJSONString(map);
    }



}
