package com.hp.up.backend.controller;

import com.hp.up.business.service.DictionaryService;
import com.hp.up.business.service.DictionaryTypeService;
import com.hp.up.core.Entity.Dictionary;
import com.hp.up.core.common.Constants;
import com.hp.up.core.enums.ResponseStatus;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.hp.up.backend.controller
 * Created by haopeng on 2017/9/15  23:58.
 */

@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends BaseController <Dictionary>{

    @Autowired
    DictionaryService dictionaryService;


    /**
     * get dictionaryList by dictionaryTypeId
     */
    @RequestMapping(value = "/{type_code}/list",method = RequestMethod.GET)
    public @ResponseBody String dictionaryList(PageDto pageDto, @PathVariable String type_code) {

        Dictionary dictionary = new Dictionary();
        dictionary.setType_code(type_code);
        PagingList<Dictionary> dictionaryPagingList = dictionaryService.getDictionaryByTypeCode(pageDto,dictionary);
        return convert2DatatablesJson(dictionaryPagingList);
    }

    /**
     * delete dictionary by id
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDictionary(@PathVariable("id") Long id) {
        int i = dictionaryService.deleteById(id);
        if (i == 1) {
            logger.info(Constants.LOGPREFIX + "delete dictionary! dictionaryId : " + id);
            return ResponseStatus.OK.toJson();
        } else {
            return ResponseStatus.FAILURE_DELETE.toJson();
        }

    }

}
