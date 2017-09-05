package com.hp.up.business.service;

import com.hp.up.core.Entity.BaseEntity;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * service 基类
 * @Author haopeng
 * @Date 2017/9/5 17:41
 */
public interface BaseService <E extends BaseEntity> extends InitializingBean {

    E getById(Long id);

    List<E> getByIds(List<Long> ids);

    Boolean exists(Long id);

    List<E> getAll();

    int save(E entity);

    E saveAndReturn(E entity);

    void save(List<E> entities);

    int remove(Long id);

    void remove(List<Long> ids);

    E update(E entity);

    Long getCount();

}

