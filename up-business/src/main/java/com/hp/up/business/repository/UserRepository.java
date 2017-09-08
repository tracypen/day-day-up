package com.hp.up.business.repository;

import com.hp.up.core.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 *
 * Created by haopeng on 2017/8/7  22:24.
 */
@Component
public interface UserRepository extends BaseRepository{

    public User findUserByName(@Param("name") String name);

    public int remove(Long id);

    public int updateLastLoginTime(Long id);
}
