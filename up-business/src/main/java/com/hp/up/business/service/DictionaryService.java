package com.hp.up.business.service;

import com.hp.up.core.Entity.Dictionary;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;

/**
 * @Author haopeng
 * @Date 2017/9/15 16:34
 */
public interface DictionaryService extends BaseService<Dictionary>{
    //get dictionary pageList
    PagingList<Dictionary> getDictionaryPage(PageDto pageDto, Dictionary dictionary);

    //delete
    int deleteById(Long id);


}
