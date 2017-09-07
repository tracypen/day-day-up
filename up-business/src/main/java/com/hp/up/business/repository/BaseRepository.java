package com.hp.up.business.repository;

import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/7 17:11
 */
public interface BaseRepository <E extends Serializable> extends InitializingBean{



    E get(Long id);

    boolean exists(Long id);

    List<E> getAll();

    Long getCount();

    int save(E entity);

    int update(E entity);

    int remove(Long id);
}
