package com.hp.up.business.service.impl;

import com.hp.up.business.repository.BaseRepository;
import com.hp.up.business.service.BaseService;
import com.hp.up.core.Entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/7 17:09
 */
public abstract class BaseServiceImpl <E extends BaseEntity> implements BaseService<E> {

    protected static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected BaseRepository<E> baseRepository;


    @Cacheable(value = "resourceCache", key = "#id", condition = "#id gt 0")
    public E getById(Long id) {
        System.out.println("query database !!!");
        return baseRepository.get(id);
    }

    public List<E> getByIds(List<Long> ids) {
        List<E> entities = new LinkedList<E>();
        for (Long id : ids) {
            E entity = getById(id);
            if (entity != null) {
                entities.add(entity);
            }
        }
        return entities;
    }

    @Cacheable(value = "resourceCache", key = "#id", condition = "#id gt 0")
    public Boolean exists(Long id) {
        return getById(id) != null;
    }

    public List<E> getAll() {
        return baseRepository.getAll();
    }

    @Transactional
    @CachePut(value = "resourceCache", key = "#entity.id")
    public int save(E entity) {
        entity.setCreateDate(new Date());
        int count = baseRepository.save(entity);
        return count;
    }

    public void save(List<E> entities) {
        for (E entity : entities) {
            save(entity);
        }
    }

    public E saveAndReturn(E entity) {
        save(entity);
        if (entity.getId() != null) {
            return getById(entity.getId());
        }
        return null;
    }

    @CacheEvict(value = { "resourceCache"}, key = "#id", condition = "#id gt 0")
    public int remove(Long id) {
        E entity = getById(id);
        if (entity != null) {
            entity.beforRemove();
            int count = baseRepository.remove(id);
            entity.afterRemove();
            return count;
        }
        return 0;
    }

    public void remove(List<Long> ids) {
        for (Long id : ids) {
            remove(id);
        }
    }

   // @CachePut(value = "e:entity", key = "#entity.id")
    public E update(E entity) {
        entity.beforUpdate();
        if (entity.getModifyDate() == null) {
            entity.setModifyDate(new Date());
        }
        int count = baseRepository.update(entity);
        if (count > 0 && entity.getId() != null && entity.getId() > 0) {
            entity = getById(entity.getId());
            if (entity != null) {
                entity.afterUpdate();
            }
        }
        return entity;
    }

    public Long getCount() {
        long count = baseRepository.getCount();
        return count > 0 ? count : 0L;
    }


    public abstract   void afterPropertiesSet() throws Exception ;
}
