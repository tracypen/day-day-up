package com.hp.up.business.service;

import com.hp.up.core.Entity.District;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;

/**
 * Created by haopeng on 2017/10/23 10:59
 */
public interface DistrictService extends BaseService<District>{

    /**
     * 获取区域 pageList
     * @param pageDto 分页对象
     * @param district 区域
     * @return
     */
    public PagingList<District> getDistrictPage(PageDto pageDto, District district);

    /**
     * 删除区域对象
     * @param id 主键
     * @return int
     */
    int deleteById(Long id);

    /**
     * 删除区域对象
     * @param code 编码
     * @return int
     */
    int deleteByCode(String code);

    /**
     * 根据code获取单个实例
     * @param code
     * @return
     */
    public District getByCode(String code);

}

