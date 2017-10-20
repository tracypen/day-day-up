package com.hp.up.backend.controller;

import com.google.common.collect.Lists;
import com.hp.up.business.service.PermissionService;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Permission;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.utils.ZTree.ZTree;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

/**
 * @Author haopeng
 * @Date 2017/9/19 17:21
 */
@Controller
@RequestMapping("system/resource")
public class SystemResourceController extends BaseController<SystemResource> {
    @Autowired
    private SystemResourceService systemResourceService;

    public static final Logger logger = LoggerFactory.getLogger(SystemResourceController.class);

    @Autowired
    private PermissionService permissionService;

    /**
     * jump to system resource page
     */
    @RequestMapping
    public String resourcesPage() {
        return "/system/resources/resource";
    }

    /**
     * get systemResources zTree menu
     */
    @RequestMapping(value = {"/all", "ajax"})
    public @ResponseBody
    List<ZTree> getAll() {

        List<SystemResource> resourcesAll = systemResourceService.getAll();
       // List<SystemResource> resources = Lists.newArrayList();
        // 屏蔽数据
        //for (SystemResource resource : resourcesAll) {
        //    if (!resource.getIdentity().equals("resource")) {
        //        resources.add(resource);
        //    }
        //}
        return SystemResource.getZTreeList(resourcesAll);
    }

    /**
     * get singleton systemResource detail whit permissionList
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getSystemResourceById(ModelMap map, @PathVariable Long id, Boolean allPermission,Boolean show_oper_btn) {

        SystemResource systemResource = systemResourceService.getById(id);

        map.put("systemResource", systemResource);

        map.put("show_oper_btn",show_oper_btn);

        if (null != allPermission && allPermission.equals(Boolean.TRUE)) {
            //获取所有权限list
            List<Permission> permissions = permissionService.getAll();

            //转化为ztree的字段（便于页面展示）
            List<ZTree> permissionList = convert2Ztree(systemResource.getPermissionList(), permissions);
            map.put("allPermission", permissionList);
            return "/system/resources/oer_perm";
        }

        return "/system/resources/info";
    }


    /**
     * update systemResources include permission
     */
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Boolean> updateByAjax(@PathVariable("id") Long id, SystemResource systemResource) {

        SystemResource byId = systemResourceService.getById(id);

        SystemResource update = systemResourceService.update( convert2update( byId, systemResource));

        if (null != update) {
            return super.getJsonResponseEntity(Boolean.TRUE);
        }
        return super.getJsonResponseEntity(Boolean.FALSE);
    }


    //将resources实体转化为ztree实体 --便于页面展示数据
    public List<ZTree> convert2Ztree(List<Permission> permissionsHave, List<Permission> permissionsAll) {

        List<ZTree> zTrees = Lists.newArrayList();
        if (null != permissionsAll) {
            for (Permission permission : permissionsAll) {
                if (null != permission) {
                    ZTree zTree = new ZTree();
                    zTree.setId(permission.getId());
                    zTree.setName(permission.getName());
                    zTree.setIdentity(permission.getPermission());
                    zTree.setDescription(permission.getDescription());
                    zTree.setChecked(isChecked(permission, permissionsHave));
                    zTrees.add(zTree);
                }
            }
        }
        return zTrees;
    }

    //判断该权限是都是该资源本身拥有的
    public boolean isChecked(Permission permission, List<Permission> permissionsHave) {

        boolean checked = Boolean.FALSE;
        if (null != permissionsHave && permissionsHave.size() > 0) {
            for (Permission perm : permissionsHave) {
                if (Objects.equals(permission.getId(), perm.getId())) {
                    checked = Boolean.TRUE;
                    break;
                }
            }
        }
        return checked;
    }

   public SystemResource convert2update(SystemResource dbResource, SystemResource systemResource){
        if (null != systemResource){
            if (StringUtils.isNotBlank(systemResource.getName())){
                dbResource.setName(systemResource.getName());
            }
            if (StringUtils.isNotBlank(systemResource.getIcon())){
                dbResource.setIcon(systemResource.getIcon());
            }
            if (StringUtils.isNotBlank(systemResource.getIdentity())){
                dbResource.setIdentity(systemResource.getIdentity());
            }
            if (null != systemResource.getParentId()){
                dbResource.setParentId(systemResource.getParentId());
            }
            if (StringUtils.isNotBlank(systemResource.getParentIds())){
                dbResource.setParentIds(systemResource.getParentIds());
            }
            if (StringUtils.isNotBlank(systemResource.getPermissions())){
                dbResource.setPermissions(systemResource.getPermissions());
            }
            if (null != systemResource.getOwner()){
                dbResource.setOwner(systemResource.getOwner());
            }
            if (StringUtils.isNotBlank(systemResource.getUrl())){
                dbResource.setUrl(systemResource.getUrl());
            }
            if (null != systemResource.getWeight()){
                dbResource.setWeight(systemResource.getWeight());
            }
            if (null != systemResource.getShow()){
                dbResource.setShow(systemResource.getShow());
            }
        }
        return dbResource;
    }


}
