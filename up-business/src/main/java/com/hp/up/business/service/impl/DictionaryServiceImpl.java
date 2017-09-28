package com.hp.up.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.up.business.repository.DictionaryRepository;
import com.hp.up.business.service.DictionaryService;
import com.hp.up.core.Entity.Dictionary;
import com.hp.up.core.annotation.Log;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/15 16:36
 */
@Service
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Transactional
    @Log(module = "系统数据字典", description = "删除数据字典")
    public int deleteById(Long id) {
        return dictionaryRepository.deleteById(id);
    }

    @Transactional
    @Log(module = "系统数据字典", description = "添加数据字典")
    public int save(Dictionary dictionary){
       return dictionaryRepository.save(dictionary);
    }

    public PagingList<Dictionary> getDictionaryByTypeCode(PageDto pageDto, Dictionary dictionary) {

        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<Dictionary> dictionaryList = dictionaryRepository.getDictionaryByTypeCode(dictionary);

        PageInfo<Dictionary> pageInfo = new PageInfo<Dictionary>(dictionaryList);

        return new PagingList<Dictionary>(dictionaryList, pageInfo);
    }

    public void afterPropertiesSet() throws Exception {
        super.baseRepository = dictionaryRepository;
    }
}
