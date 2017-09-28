package com.hp.up.business.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.up.business.repository.DictionaryRepository;
import com.hp.up.business.repository.DictionaryTypeRepository;
import com.hp.up.business.service.DictionaryTypeService;
import com.hp.up.core.Entity.DictionaryType;
import com.hp.up.core.annotation.Log;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.hp.up.business.service.impl
 * Created by haopeng on 2017/9/13  22:20.
 */
@Service
public class DictionaryTypeServiceImpl extends BaseServiceImpl<DictionaryType> implements DictionaryTypeService {

    @Autowired
    DictionaryTypeRepository dictionaryTypeRepository;

    @Autowired
    DictionaryRepository dictionaryRepository;

    /**
     * 获取字典类型pageList
     * @param pageDto page
     * @param dictionaryType condition
     * @return pageList
     */
    public PagingList<DictionaryType> getDictionaryTypePage(PageDto pageDto, DictionaryType dictionaryType) {

        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<DictionaryType> dictionaryTypeList = dictionaryTypeRepository.getDictionaryType(dictionaryType);

        PageInfo<DictionaryType> pageInfo = new PageInfo<DictionaryType>(dictionaryTypeList);

        return new PagingList<DictionaryType>(dictionaryTypeList, pageInfo);
    }

    @Transactional
    @Log(module = "系统字典类型", description = "删除字典类型")
    public int deleteById(Long id) {
        //先删除该类型所有字典记录
        DictionaryType dictionaryType = dictionaryTypeRepository.get(id);

        dictionaryRepository.deleDictionaryteByTypeCode(dictionaryType.getCode());

        return dictionaryTypeRepository.deleteById(id);
    }

    public void afterPropertiesSet() throws Exception {

        super.baseRepository = dictionaryTypeRepository;

    }
}
