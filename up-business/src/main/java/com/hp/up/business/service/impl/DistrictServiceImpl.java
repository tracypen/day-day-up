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
import org.apache.commons.lang3.StringUtils;
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

    private static final String LOG_MODUL = "区域管理";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public PagingList<District> getDistrictPage(PageDto pageDto, District district) {

        //MyBatis pageHelper start
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<District> districtPageList = districtRepository.getDistrict(district);

        logger.info("获取区域分页列表 List \n {}", JSONObject.toJSONString(districtPageList, Boolean.TRUE));

        //get pageInfo
        PageInfo<District> pageInfo = new PageInfo<District>(districtPageList);

        return new PagingList<District>(districtPageList, pageInfo);

    }

    @Override
    @Log(module = LOG_MODUL, description = "删除区域记录ById")
    public int deleteById(Long id) {

        logger.info(Constants.LOGPREFIX + "删除区域记录ById id: {}", id);

        return districtRepository.deleteById(id);
    }

    @Override
    @Log(module = LOG_MODUL,description = "删除区域记录ByCode")
    public int deleteByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return 0;
        }
        logger.info(Constants.LOGPREFIX + "删除区域记录ByCode code: {}", code);
        return districtRepository.deleteByCode(code);
    }

    @Override
    public District getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return new District();
        }
        return districtRepository.getByCode(code);
    }

    @Override
    @Log(module = LOG_MODUL, description = "新增区域管理")
    public int insert(District district) {

        List<District> childList = getDistrictByParentCode(district.getParentCode());
        String disCode = StringUtils.EMPTY;
        if (null != childList && !childList.isEmpty()) {
            //有子节点--查出该parentCode下最大的code 然后加1
            int pid = Integer.parseInt(childList.get(0).getCode());
            if (pid % 10000 == 0){
                disCode = pid / 10000 +1  + "0000";
            }else  if (pid % 100 == 0){
                disCode = pid / 100 +1 + "00";
            }else {

                disCode = Integer.parseInt(childList.get(0).getCode()) + 1 + StringUtils.EMPTY;
            }
        } else {
            int pid = Integer.parseInt(district.getParentCode());
            if (pid % 10000 == 0){
                disCode = pid / 10000 + "1100";
            }else  if (pid % 100 == 0){
                disCode = pid / 100 + "11";
            }

        }
        district.setCode(disCode);
        return baseRepository.save(district);
    }

    @Override
    public List<District> getDistrictByParentCode(String parentCode) {
        if (StringUtils.isBlank(parentCode)){
            return null;
        }
        return districtRepository.getDistrictByParentCode(parentCode);
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        super.baseRepository = districtRepository;
    }
}
