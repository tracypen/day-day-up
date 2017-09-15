package com.hp.up.business;

import com.hp.up.business.service.DictionaryTypeService;
import com.hp.up.core.Entity.DictionaryType;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author haopeng
 * @Date 2017/9/15 15:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestDictionaryTypeService {

    @Autowired
    DictionaryTypeService dictionaryTypeService;

    @Test
    public void  getDictionaryType(){
        PageDto dto = new PageDto();
        DictionaryType dictionaryType = new DictionaryType();
        PagingList<DictionaryType>  list = dictionaryTypeService.getDictionaryTypePage( dto,  dictionaryType);
        Assert.assertNotNull(list);
    }

    @Test
   public void deleteDictionaryType(){
      int result =  dictionaryTypeService.deleteById(2009L);
       System.out.println(result > 0 ? "success" : "failed!");
   }

}
