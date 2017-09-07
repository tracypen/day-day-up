package com.hp.up.backend.controller;

import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import com.hp.up.core.common.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Controller 基类
 *
 * @Author haopeng
 * @Date 2017/9/7 15:22
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private final String RESPONSE_ENTITY_JSON_TYPE = MediaType.APPLICATION_JSON_VALUE + "; charset=" + Constants.ENCODING_UTF8;

    private final String RESPONSE_ENTITY_TEXT_TYPE = MediaType.TEXT_HTML_VALUE + "; charset=" + Constants.ENCODING_UTF8;

    @Autowired
    UserService userService;

    /**
     * 获取当前用户
     * @return
     */
    public User getCurrentUser() {

        Subject subject = SecurityUtils.getSubject();

        String userName = (String) subject.getPrincipal();

        User currentUser = userService.getUserByName(userName);

        return currentUser;
    }
/*
    protected void populatedUser(User user, Model model) {
        // cache
        model.addAttribute(com.lirenkj.smartedu.lx.common.utils.Constants.USER_ID, user.getId().longValue());
        model.addAttribute(com.lirenkj.smartedu.lx.common.utils.Constants.CURRENT_USER, user);

        List<Menu> menus = findMenus(user);
        model.addAttribute(com.lirenkj.smartedu.lx.common.utils.Constants.MENU_LIST, menus);

        if (user.getUserGroup() == null) {
            UserIdentity identity = getUserIdentity();
            user.setUserGroup(identity);
            user = userV3Service.update(user);
        }



       // model.addAttribute(com.lirenkj.smartedu.lx.common.utils.Constants.DOMAIN, PropertiesLoader.getInstance().getProperty("media.server.domain"));

        model.addAttribute(com.lirenkj.smartedu.lx.common.utils.Constants.FRONTURL, PropertiesLoader.getInstance().getProperty("front.url"));
    }*/

/*
    private List<Menu> findMenus(UserV3 user) {
        List<Menu> menus = redisTemplate.get(MENU_BY_ID + String.valueOf(user.getId()), List.class);
        if (menus == null) {
            menus = resourceService.findMenus(user);
            redisTemplate.setex(MENU_BY_ID + String.valueOf(user.getId()), menus, MENU_BY_ID.getExpiredTime());
        }
        return menus;
    }*/

}
