package com.hp.up.backend.controller;

import com.hp.up.backend.shiro.utils.PwdUtil;
import com.hp.up.core.Entity.User;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * userController
 * @Author haopeng
 * @Date 2017/9/7 15:21
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

        private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    //配置密码散列次数
    @Value("#{propertiesReader['shiro.hashIterations']}")
    private int hashIterations;


    /**
     * jump to user list page
     */
    @RequestMapping
    public String userPage() {
        return "user/list";
    }

    /**
     * get userList with condition
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String userList(PageDto pageDto, User user) {

        PagingList<User> userList = userService.getUserPage(pageDto, user);

        return convert2DatatablesJson(userList);
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
     * jump to edit page
     */
    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String editPage(@PathVariable Long id,ModelMap map) {
        if (null != id && id >0){
            User user = userService.getById(id);
            map.put("user",user);
        }
        return "/user/edit";
    }


    /**
     * get current user info
     */
    @RequestMapping(value = {"/info"}, method = RequestMethod.GET)
    @ResponseBody
    public User getCurrentUserInfo() {
        User currentUser = super.getCurrentUser();
        return currentUser;
    }


    /**
     * update or add user
     */
    @RequestMapping(value = {"/add","/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addOrUpdate(@RequestBody User user) {
        //设置密码和盐
        int result = userService.saveOrUpdateUser(getPwd(user));
        if (result > 0) {
            return super.getJsonResponseEntity(Boolean.TRUE);
        }
        return super.getJsonResponseEntity(Boolean.FALSE);
    }

    /**
     * export Excel
     */
    @RequestMapping(value = "export",method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response)throws Exception{
        InputStream is=userService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }


    /**
     * 密码加密
     */
    public User getPwd(User user) {
        if (StringUtils.isNotBlank(user.getPassword())){
            //通过UUID作为用户密码盐值
            String salt = PwdUtil.getUUID();
            user.setSalt(salt);
            user.setPassword(PwdUtil.encrypt(user.getPassword(), salt, hashIterations));
        }
        return user;
    }


}
