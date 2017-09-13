package com.hp.up.backend.controller;

import com.hp.up.business.service.DictionaryTypeService;
import com.hp.up.core.Entity.DictionaryType;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * dictionaryTypeController
 * com.hp.up.backend.controller
 * Created by haopeng on 2017/9/13  23:14.
 */
@Controller
@RequestMapping("/dictionaryType")
public class DictionaryTypeController extends BaseController {

    @Autowired
    DictionaryTypeService dictionaryTypeService;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * jump to dictionaryType list page
     */
    @RequestMapping
    public String dictionaryPage() {
        return "dictionaryType/list";
    }

    /**
     * get dictionaryTypeList with condition
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    String dictionaryTypeList(PageDto pageDto, DictionaryType dictionaryType) {

        PagingList<DictionaryType> dictionaryTypeList = dictionaryTypeService.getDictionaryTypePage(pageDto, dictionaryType);

        return convert2DatatavlesJson(dictionaryTypeList);
    }

    /**
     * delete dictionaryType by id
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        int i = dictionaryTypeService.deleteById(id);
        if (i == 1) {
            logger.info("delete dictionaryType! dictionaryTypeId : " + id);
            return ResponseStatus.OK.toJson();
        } else {
            return ResponseStatus.FAILURE_DELETE.toJson();
        }

    }

    /**
     * update or add dictionaryType
     */
    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity insertUser(DictionaryType dictionaryType) {
        if (null != dictionaryType.getId()) {
            dictionaryTypeService.update(dictionaryType);
            return super.getJsonResponseEntity(Boolean.TRUE);
        }
        int result = dictionaryTypeService.save(dictionaryType);
        if (result > 0) {
            return super.getJsonResponseEntity(Boolean.TRUE);
        }
        return super.getJsonResponseEntity(Boolean.FALSE);
    }


}
