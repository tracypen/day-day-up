package com.hp.up.business.service;

import com.hp.up.core.Entity.DictionaryType;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;

/**
 * com.hp.up.business.service
 * Created by haopeng on 2017/9/13  22:20.
 */
public interface DictionaryTypeService extends BaseService<DictionaryType>{

    /**
     * 获取字典类型pageList
     */
    PagingList<DictionaryType> getDictionaryTypePage(PageDto pageDto, DictionaryType dictionaryType);

    /**
     * 删除字典类型（逻辑删除）
     */
    int deleteById(Long id);



}
