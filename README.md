# day-day-up
## 项目简介
- 1.基于SSM、maven搭建的web项目(包括前台后台)
- 2.集成shiro权限管理框架 
- 3.redis 数据缓存
- 4.quartz 任务调度
- 5.activemq 消息队列
- 6.bootstrap
- 7.sitemesh
- 8.elasticsearch



## 模块说明
- up-parent         聚合模块
- up-core           工程核心层
- up-business       工程业务层
- up-backend        后台模块
- maple-front       前台模块
- maple-producer    jms生产者
- maple-consumer    jms消费者
- maple-system      ftp文件管理模块
- maple-utils       API接口模块

## 技术选型
- 核心框架：Spring Framework 4.3.6
- 安全框架：Apache Shiro 1.3.2
- 持久层框架：Mybatis（mybatis-plus）
- 数据库连接池：Alibaba Druid 1.0.29
- Token生成和管理：JWT、Redis
- 日志管理：Log4j
- 数据库：MySQL
- 后台前端框架：Jquery EasyUI 1.5.X 和 JQuery EasyUI 1.5.x of Insdep Theme 


欢迎进群交流
#### 点击加入QQ群[245682819](https://jq.qq.com/?_wv=1027&k=47ErLEy)
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<!--securityManage-->
  <!-- 安全管理器 -->
  <bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
      <property name="realm" ref="customRealm" />

      <!--注入缓存管理器-->
      <property name="cacheManager" ref="cacheManager"/>

      <!--注入会话管理器-->
      <property name="sessionManager" ref="sessionManager" />
  </bean>

  
  
 