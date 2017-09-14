package com.hp.up.backend.controller;

import com.hp.up.backend.shiro.utils.PwdUtil;
import com.hp.up.core.Entity.User;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PageResult;
import com.hp.up.core.web.page.PagingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * userController
 * @Author haopeng
 * @Date 2017/9/7 15:21
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

        private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    //配置密码散列次数
    @Value("#{propertiesReader['shiro.hashIterations']}")
    private int hashIterations;


    /**
     * jump to user list page
     */
    @RequestMapping
    public String userPage(PageDto pageDto, User user, ModelMap model) {
        return "user/list";
    }

    /**
     * get userList with condition
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String userList(PageDto pageDto, User user) {

        PagingList<User> userList = userService.getUserPage(pageDto, user);

        return convert2DatatavlesJson(userList);
    }

    /**
     * delete user
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        int i = userService.remove(id);
        if (i == 1) {
            logger.info(Constants.LOGPREFIX + "delete success! userId : "+id);
            return ResponseStatus.OK.toJson();

        } else {
            return ResponseStatus.FAILURE_DELETE.toJson();
        }

    }

    /**
     * update or add user
     */
    @RequestMapping(value = {"/add","/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity insertUser(User user) {
        //设置密码和盐
        int result = userService.save(getPwd(user));
        if (result > 0) {
            return super.getJsonResponseEntity(Boolean.TRUE);
        }
        return super.getJsonResponseEntity(Boolean.FALSE);
    }


    /**
     * 密码加密
     */
    public User getPwd(User user) {
        //通过UUID作为用户密码盐值
        String salt = PwdUtil.getUUID();
        user.setSalt(salt);
        user.setPassword(PwdUtil.encrypt(user.getPassword(), salt, hashIterations));
        return user;
    }


}
