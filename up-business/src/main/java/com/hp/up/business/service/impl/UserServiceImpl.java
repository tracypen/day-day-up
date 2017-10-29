package com.hp.up.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.io.ByteSource;
import com.hp.up.business.repository.UserRepository;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.MailEntity;
import com.hp.up.core.Entity.User;
import com.hp.up.core.annotation.Log;
import com.hp.up.core.utils.date.DateUtils;
import com.hp.up.core.utils.mail.JavaMailUtils;
import com.hp.up.core.utils.poi.WriteExcel;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * com.hp.up.business.service.impl
 * Created by haopeng on 2017/8/7  21:53.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String userName) {
        return userRepository.findUserByName(userName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @Log(module = "系统用户管理", description = "删除用户")
    public int remove(Long id) {
        if (null == id || id <= 0) {
            logger.error("");
            throw new IllegalArgumentException();
        }

        //删除用户角色关联表记录
        //  authRepository.removeUser(id);

        return userRepository.remove(id);
    }

    @Override
    public PagingList<User> getUserPage(PageDto pageDto, User user) {

        PageHelper.startPage(pageDto.getPageNum(), pageDto.getiDisplayLength());

        List<User> userList = userRepository.getUsers(user);

        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        return new PagingList<User>(userList, pageInfo);
    }

    @Override
    @Transactional
    @Log(module = "系统用户管理", description = "新增用户")
    public int save(final User user) {
        return baseRepository.save(user);
    }

    @Override
    public int updateLastLoginTime(Long id) {
        return userRepository.updateLastLoginTime(id);
    }

    @Override
    @Transactional
    @Log(module = "系统用户管理", description = "新增/修改用户")
    public int saveOrUpdateUser(User user) {
        if ((null != user.getId() && user.getId() > 0)) {
            User resultUser = this.update(user);
            return null != resultUser ? 1 : 0;
        }
        return this.save(user);
    }

    @Override
    public InputStream getInputStream() throws Exception {
        String[] title = new String[]{"id", "用户名", "E-mail", "性别", "真实姓名", "电话"};
        List<User> plist = userRepository.getAll();
        List<Object[]> dataList = new ArrayList<Object[]>();
        for (int i = 0; i < plist.size(); i++) {
            Object[] obj = new Object[6];
            obj[0] = plist.get(i).getId();
            obj[1] = plist.get(i).getName();
            obj[2] = plist.get(i).getEmail();
            obj[3] = (null != (plist.get(i).getGender()) && (plist.get(i).getGender() == 1) ? "男" : "女");
            obj[4] = plist.get(i).getUserRealName();
            obj[5] = plist.get(i).getPhone();
            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.baseRepository = userRepository;
    }
}
