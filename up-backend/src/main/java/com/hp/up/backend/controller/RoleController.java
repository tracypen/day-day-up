package com.hp.up.backend.controller;

import com.hp.up.business.service.RoleService;
import com.hp.up.business.service.SystemResourceService;
import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.SystemResource;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.web.page.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * roleController
 *
 * @Author haopeng
 * @Date 2017/9/19 13:42
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController<Role> {

    @Autowired
    RoleService roleService;

    @Autowired
    SystemResourceService systemResourceService;

    @RequestMapping
    public String rolePage() {
        return "system/role/role";
    }

    /**
     * get all roles
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody String getAll() {
        // get roleList
        List<Role> roleList = roleService.getAll();
        PagingList<Role> list = new PagingList<Role>(roleList, null);
        return convert2DatatablesJson(list);

    }

    /**
     * get single role's detail with all permission
     */
    @RequestMapping(value = "/{id}/permission", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getSingleRoleWithPermission(ModelMap modelMap, @PathVariable("id") Long id) {

        Role role = roleService.getById(id);

        //get resources permission
        List<Map<String, Object>> resourceTree = roleService.getResourceTree(id);

        modelMap.put("role", role);
        modelMap.put("treeList", resourceTree);

        //return JSON data
        return getJsonResponseEntity(modelMap);

    }


    /**
     * delete role by roleId
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody String deleteRoleById(@PathVariable("id") Long id) {
        int result = roleService.remove(id);
        if (result <= 0) {
            logger.info(Constants.LOGPREFIX + "delete role failure! roleId : " + id);
            return ResponseStatus.FAILURE_DELETE.toJson();
        }
        logger.info(Constants.LOGPREFIX + "delete role success! roleId : " + id);
        return ResponseStatus.OK.toJson();
    }

    /**
     * update role's permission that operate for resources
     */
    @RequestMapping(value = "/updatRoleResourPermission", method = RequestMethod.POST)
    public @ResponseBody String updatRoleResourPermission(String resourceId, Long roleId) {

        String resourceID = "";
        if (!"".equals(resourceId) && null != resourceId) {
            if (resourceId.indexOf(",") != -1) {
                String[] split = resourceId.split(",");
                for (String string : split) {
                    if (string.indexOf("_") != -1) {
                        resourceID += string + ",";
                    }
                }
                resourceID = resourceID.substring(0, resourceID.length() - 1);
            }
        }

        roleService.updatRoleResourPermission(roleId, resourceID);
        return ResponseStatus.OK.toJson();

    }


    /**
     * add or update role
     */
    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
    public @ResponseBody String saveOrUpdateRole(Role role) {

        int result = 0;
        if (null != role) {
            if (null != role.getId() && role.getId() > 0) {
                //update
                Role updateRole = roleService.update(role);
                if (null != updateRole) {
                    result++;
                }
            } else {
                //add
                result = roleService.save(role);
            }
        }
        return result > 0 ? ResponseStatus.OK.toJson() : ResponseStatus.FAILURE_UPDATE.toJson();
    }


}
