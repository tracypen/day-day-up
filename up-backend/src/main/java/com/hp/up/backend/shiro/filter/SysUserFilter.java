package com.hp.up.backend.shiro.filter;

import com.hp.up.business.service.SystemResourceService;
import com.hp.up.business.service.UserService;
import com.hp.up.core.Entity.Menu;
import com.hp.up.core.Entity.User;
import com.hp.up.core.common.Constants;
import com.hp.up.core.web.shiro.UserShiro;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/12 11:28
 */
public class SysUserFilter extends AccessControlFilter {

    @Autowired
    UserService userService;

    @Autowired
    private SystemResourceService resourceService;



    @Override
    protected boolean preHandle(ServletRequest req, ServletResponse res) throws Exception {
        Subject subject = getSubject(req, res);
        if (subject != null) {
            if (subject.isAuthenticated()) {
                UserShiro userShiro = (UserShiro) subject.getPrincipal();
                setUserAttribute(userShiro.getName(),req);
                if (req.getAttribute(Constants.CURRENT_USERNAME) != null) {
                    ((HttpServletRequest) req).getSession().setAttribute(Constants.CURRENT_USERNAME, userShiro.getName());
                }
            }
        }
        return true;
    }

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        User user = (User) request.getAttribute(Constants.CURRENT_USER);
        if (user == null) {
            return true;
        }

        if (Boolean.TRUE.equals(user.getStatus() == 0)){
            getSubject(request, response).logout();
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
        return true;
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        getSubject(request, response).logout();
        saveRequestAndRedirectToLogin(request, response);
        return true;
    }



    private void setUserAttribute(String username, ServletRequest request) {
        // cache
        User user = userService.getUserByName(username);
        if (user == null) {
            return;
        }
        request.setAttribute(Constants.USER_ID, user.getId().longValue());
        request.setAttribute(Constants.CURRENT_USER, user);

        List<Menu> menus = findMenus(user);
        request.setAttribute(Constants.MENU_LIST, menus);

       /* request.setAttribute(Constants.DOMAIN, PropertiesLoader.getInstance().getProperty("media.server.domain"));

        request.setAttribute(Constants.FRONTURL, PropertiesLoader.getInstance().getProperty("front.url"));

        request.setAttribute(Constants.FRONTURL, PropertiesLoader.getInstance().getProperty("front.url"));
        request.setAttribute(Constants.ADMINURL, PropertiesLoader.getInstance().getProperty("admin.url"));*/

    }


    private List<Menu> findMenus(User user) {
        List<Menu> menus = null;
       // menus =   redisTemplate.get(MENU_BY_ID + String.valueOf(user.getId()), List.class);
        if (menus == null) {
            menus = resourceService.findMenus(user);
           // redisTemplate.setex(MENU_BY_ID + String.valueOf(user.getId()), menus, MENU_BY_ID.getExpiredTime());
        }
        return menus;
    }
}
