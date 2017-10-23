package com.hp.up.business.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.up.business.repository.DistrictRepository;
import com.hp.up.business.service.DistrictService;
import com.hp.up.core.Entity.District;
import com.hp.up.core.annotation.Log;
import com.hp.up.core.common.Constants;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haopeng on 2017/10/23 11:01
 */
@Service
public class DistrictServiceImpl extends BaseServiceImpl<District> implements DistrictService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public PagingList<District> getDistrictPage(PageDto pageDto, District district) {

        //MyBatis pageHelper start
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<District> districtPageList = districtRepository.getDistrict(district);

        logger.info("获取区域分页列表 List \n {}" , JSONObject.toJSONString(districtPageList,Boolean.TRUE));

        //get pageInfo
        PageInfo<District> pageInfo = new PageInfo<District>(districtPageList);

        return new PagingList<District>(districtPageList, pageInfo);

    }

    @Override
    @Log(module = "区域管理", description = "删除区域记录ById")
    public int deleteById(Long id) {

        logger.info(Constants.LOGPREFIX + "删除区域记录ById id: {}" , id);

        return districtRepository.deleteById(id);
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        super.baseRepository = districtRepository;

    }
}
