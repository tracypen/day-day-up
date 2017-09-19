package com.hp.up.backend.controller;

import com.hp.up.business.service.RoleService;
import com.hp.up.core.Entity.Role;
import com.hp.up.core.web.page.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * rolerController
 * @Author haopeng
 * @Date 2017/9/19 13:42
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController<Role>{

    @Autowired
    RoleService roleService;

    @RequestMapping
    public String rolePage(){
        return "system/role/role";
    }

    /**
     * 获取全部角色
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public @ResponseBody String getAll(){
        //获取roleList
       List<Role> roleList = roleService.getAll();
        PagingList<Role> list = new PagingList<Role>(roleList,null);
        return convert2DatatablesJson(list);

    }
}
