package com.hp.up.backend.shiro;

import com.hp.up.business.service.PermissionService;
import com.hp.up.business.service.RoleService;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.User;
import com.hp.up.core.web.shiro.UserShiro;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
public class UserAuthRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserAuthRealm.class);
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        User user = userService.getUserByName(usernamePasswordToken.getUsername());

        if (user == null) {

            throw new UnknownAccountException();//没找到帐号

        }

      /*  if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        UserShiro userShiro = buildUserShiro(user);

        SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(userShiro, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());

        return authInfo;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        UserShiro userShiro = (UserShiro) principals;
        User user = userService.getUserByName(userShiro.getName());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //角色
        authorizationInfo.setRoles(roleService.getUserRoles(user));
        //权限
        authorizationInfo.setStringPermissions(permissionService.getStringPermissions(user));
        return authorizationInfo;
    }


    private UserShiro buildUserShiro(User user) {

        return new UserShiro(user.getId(), user.getName(), user.getPassword(), user.getRealName());
    }

}
