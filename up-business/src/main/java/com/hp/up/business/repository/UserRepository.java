package com.hp.up.business.repository;

import com.hp.up.core.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by haopeng on 2017/8/7  22:24.
 */
@Component
public interface UserRepository extends BaseRepository<User>{

    public User findUserByName(@Param("name") String name);

    public int updateLastLoginTime(Long id);

    public List<User> getUsers(User user);
}
