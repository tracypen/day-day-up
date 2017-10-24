package com.hp.up.business.repository;

import com.hp.up.core.Entity.District;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haopeng on 2017/10/23 11:03
 */
@Component
public interface DistrictRepository extends BaseRepository<District> {

    public List<District> getDistrict(District district);

    public int deleteById(Long id);

    public int deleteByCode(String code) ;

    public District getByCode(String code);




    }
