package com.hp.up.business.repository;

import com.hp.up.core.Entity.DictionaryType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.hp.up.business.repository
 * Created by haopeng on 2017/9/13  22:23.
 */
@Component
public interface DictionaryTypeRepository extends BaseRepository<DictionaryType> {

    public List<DictionaryType> getDictionaryType(DictionaryType dictionaryType);

    public int deleteById(Long id);



}
