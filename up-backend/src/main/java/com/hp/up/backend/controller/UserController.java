package com.hp.up.backend.controller;

import com.hp.up.core.Entity.User;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/7 15:21
 */
@Controller
@RequestMapping("system/role")
public class UserController extends BaseController{

    public List<User> userList(){

        return null;
    }


    /**
     * delete user
     */
    @RequestMapping(value = { "{id}/delete" })
    public @ResponseBody
    String delete(ModelMap model, @PathVariable("id") Long id, User user) {
        int i = userService.deleteUser(id);
        if (i == 1) {
            return ResponseStatus.OK.toJson();
        } else {
            return ResponseStatus.FAILURE_DELETE.toJson();
        }

    }

}
