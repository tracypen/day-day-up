package com.hp.up.backend.controller;

import com.google.common.collect.Lists;
import com.hp.up.business.service.DistrictService;
import com.hp.up.core.Entity.District;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.utils.convert.BeanToMapConvert;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class DistrictController extends BaseController<District>{

    @Autowired
    DistrictService districtService;

    @RequestMapping
    public String districtPage() {
        return "org_structure/district/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    String districtList(PageDto pageDto, District district) {

        PagingList<District> districtList = districtService.getDistrictPage(pageDto, district);

        return convert2DatatablesJson(districtList);
    }


    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity districtTree(PageDto pageDto) {

        PagingList<District> districtList = districtService.getDistrictPage(pageDto, null);

        List<Map<String, Object>> treeResult = convert2ZTreeJson(districtList);

        return super.getJsonResponseEntity(treeResult);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDictionaryType(@PathVariable("id") Long id) {
        int i = districtService.deleteById(id);
        if (i == 1) {
            logger.info(Constants.LOGPREFIX + "delete district id :{} By userId :{}" , id , super.getUserShiroInfo().getId());
            return ResponseStatus.OK.toJson();
        } else {
            return ResponseStatus.FAILURE_DELETE.toJson();
        }

    }


    /**
     * 转化districtList返回值
     * @param districtList district集合
     * @return List
     */
    private List<Map<String,Object>> convert2ZTreeJson(PagingList<District> districtList){
        List<Map<String, Object>> result = Lists.newArrayList();
        if (null != districtList.getData() && !districtList.getData().isEmpty()){
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
