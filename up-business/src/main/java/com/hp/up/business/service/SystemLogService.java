package com.hp.up.business.service;

import com.hp.up.core.Entity.SystemLog;
import com.hp.up.core.web.page.PageDto;
import com.hp.up.core.web.page.PagingList;

/**
 * @Author haopeng
 * @Date 2017/9/27 9:42
 */
public interface SystemLogService extends BaseService<SystemLog>  {


    PagingList<SystemLog> getSystemLogPage(PageDto pageDto, SystemLog systemLog);


}
