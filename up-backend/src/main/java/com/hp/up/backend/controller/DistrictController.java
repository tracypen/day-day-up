package com.hp.up.backend.controller;

import com.google.common.collect.Lists;
import com.hp.up.business.service.DistrictService;
import com.hp.up.core.Entity.District;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.utils.convert.BeanToMapConvert;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by haopeng on 2017/10/23 10:32
 */
@Controller
@RequestMapping("/org_structure/district")
public class DistrictController extends BaseController<District> {

    @Autowired
    DistrictService districtService;

    @RequestMapping
    public String districtPage(ModelMap modelMap) {
        modelMap.put("list", districtService.getAll());
        return "org_structure/district/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    String districtList(PageDto pageDto, District district) {

        PagingList<District> districtList = districtService.getDistrictPage(pageDto, district);

        return convert2DatatablesJson(districtList);
    }


    /**
     * 区域属性结构JSON数据
     * @param pageDto pageDto
     * @return JSON
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity districtTree(PageDto pageDto) {

        PagingList<District> districtList = districtService.getDistrictPage(pageDto, null);

        List<Map<String, Object>> treeResult = convert2ZTreeJson(districtList);

        return super.getJsonResponseEntity(treeResult);
    }


    /**
     * 根据code删除单条记录
     * @param code 编码
     * @return JSON
     */
    @RequestMapping(value = "/{code}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDictionaryType(@PathVariable("code") String code) {
        int i = districtService.deleteByCode(code);
        if (i == 1) {
            logger.info(Constants.LOGPREFIX + "delete district code :{} By userId :{}", code, super.getUserShiroInfo().getId());
            return ResponseStatus.OK.toJson();
        } else {
            return ResponseStatus.FAILURE_DELETE.toJson();
        }

    }

    /**
     * 新增或修改页面
     * @param code     编码
     * @param modelMap model
     * @return page
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String addorUpdatePage(String code, String parent_code, @ModelAttribute String level, ModelMap modelMap) {
        District district = new District();
        if (StringUtils.isNotBlank(code)) {
            //更新
            district = districtService.getByCode(code);
            modelMap.put("doUpdate", Boolean.TRUE);
        }else{
            //新增
            district.setParentCode(parent_code);
        }
        modelMap.put("district", district);
        return "/org_structure/district/edit";
    }


    /**
     * 新增或修改
     * @param district dto
     * @return JSON
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String doAddorUpdate(District district) {
        if (null != district && null != district.getId() && district.getId() > 0) {
            District update = districtService.update(district);
            return null != update ? ResponseStatus.OK.toJson() : ResponseStatus.FAILURE_UPDATE.toJson();
        }
        int save = districtService.insert(district);
        return save > 0 ? ResponseStatus.OK.toJson() : ResponseStatus.FAILURE_ADD.toJson();
    }


    /**
     * 转化districtList返回值
     * @param districtList district集合
     * @return List
     */
    private List<Map<String, Object>> convert2ZTreeJson(PagingList<District> districtList) {
        List<Map<String, Object>> result = Lists.newArrayList();
        if (null != districtList.getData() && !districtList.getData().isEmpty()) {
            for (District district : districtList) {
                Map<String, Object> map = BeanToMapConvert.toMap(district);
                map.remove("parent_id");
                map.put("parent_id", district.getParentCode());
                result.add(map);
            }
        }
        return result;
    }

}
