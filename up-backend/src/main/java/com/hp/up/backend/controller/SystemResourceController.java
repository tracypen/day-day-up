package com.hp.up.backend.controller;

import com.google.common.collect.Lists;
import com.hp.up.business.service.PermissionService;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.utils.ZTree.ZTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/19 17:21
 */
@Controller
@RequestMapping("system/resource")
public class SystemResourceController extends BaseController<SystemResource>{
    @Autowired
    private SystemResourceService systemResourceService;

    public static final Logger logger = LoggerFactory.getLogger(SystemResourceController.class);

    @Autowired
    private PermissionService permissionService;

    //系统资源页面
    @RequestMapping
    public String resourcesPage(){
        return "/system/resources/resource";
    }

    //系统资源zTree
    @RequestMapping(value = {"/all","ajax"})
    public @ResponseBody List<ZTree> getAll() {
      //  List<Permission> permissions = permissionService.getAll();

      //  model.put("permissions", permissions);
        List<SystemResource> resourcesAll = systemResourceService.getAll();
        List<SystemResource> resources = Lists.newArrayList();
        // 屏蔽数据
        //for (SystemResource resource : resourcesAll) {
        //    if (!resource.getIdentity().equals("resource")) {
        //        resources.add(resource);
        //    }
        //}
        return SystemResource.getZTreeList(resourcesAll);
    }

    //获取单个资源详情--包括权限
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getSystemResourceById(ModelMap map , @PathVariable Long id) {

        SystemResource systemResource = systemResourceService.getById(id);

        map.put("systemResource",systemResource);

        return "/system/resources/info";
    }


}
