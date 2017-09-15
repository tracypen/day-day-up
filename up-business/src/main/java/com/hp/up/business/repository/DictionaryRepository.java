package com.hp.up.business.repository;

import com.hp.up.core.Entity.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/15 16:37
 */
@Component
public interface DictionaryRepository extends BaseRepository<Dictionary> {

    public List<Dictionary> getDictionary(Dictionary dictionary);

    public int deleteById(Long id);

}
