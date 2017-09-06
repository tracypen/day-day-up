package com.hp.up.backend.shiro;

import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm 注入认证、授权数据源
 * Created by haopeng on 2017/9/3  18:53
 */
public class UserAuthRealm extends AuthorizingRealm{
    private static final Logger logger = LoggerFactory.getLogger(UserAuthRealm.class);
    @Autowired
    private UserService userService;

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        User user = userService.getUserByName(usernamePasswordToken.getUsername());
        if (user != null) {
           // this.initSession(user);
            SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
            return authInfo;
        }
            return null;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
