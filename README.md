# day-day-up
## 项目简介
- 1.基于SSM、maven搭建的web项目(包括前台后台)
- 2.集成Apache shiro权限管理框架 
- 3.使用 redis 作为缓存数据库
- 4.quartz    任务调度
- 5.activemq 消息队列
- 6.bootstrap
- 7.sitemesh
- 8.elasticsearch
-9.datatable 插件


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

  <property name="hashAlgorithmName" value="md5"/>指定hash算法为MD5；  
  <property name="hashIterations" value="2"/>指定散列次数为2次；
  <pre name="code" class="html"><property name="storedCredentialsHexEncoded"
   value="true"/>指定Hash散列值使用Hex加密存储。
  value="false"表明hash散列值用用Base64-encoded存储。
  
 
 
 //获取第1页，10条内容，默认查询总数count
 PageHelper.startPage(1, 10);
 List<Country> list = countryMapper.selectAll();
 //用PageInfo对结果进行包装
 PageInfo page = new PageInfo(list);
 //测试PageInfo全部属性
 //PageInfo包含了非常全面的分页属性
 assertEquals(1, page.getPageNum());
 assertEquals(10, page.getPageSize());
 assertEquals(1, page.getStartRow());
 assertEquals(10, page.getEndRow());
 assertEquals(183, page.getTotal());
 assertEquals(19, page.getPages());
 assertEquals(1, page.getFirstPage());
 assertEquals(8, page.getLastPage());
 assertEquals(true, page.isFirstPage());
 assertEquals(false, page.isLastPage());
 assertEquals(false, page.isHasPreviousPage());
 assertEquals(true, page.isHasNextPage());
 
 
 
 学习目标
 1.https://git.oschina.net/hawawa/easyui-rbac.git  crm基于springboot搭建的权限管理系统
 
 2.https://git.oschina.net/hawawa/WhereURP.git easyui+shiro搭建的权限管理系统
 
 
 
 
 
 
 
 	<select id="findRoleByIds" resultMap="RolePermissionResult" parameterType="list">
 		select 
 		r.id rid,
 		r.name,
 		r.role,
 		r.description,
 		r.is_show,
 		
 		p.id pid,
 		p.role_id,
 		p.resource_id,
 		p.permission_ids
 
 		from t_role r left outer join
 		t_role_resource_permission p on r.id = p.role_id where r.id in
 		<foreach collection="list" index="index" close=")" item="item" open="(" separator=",">#{item}</foreach>
 
 	</select>
 	
 		<resultMap type="Role" id="RolePermissionResult" extends="RoleResult">
    		<collection property="resourcePermissions" ofType="RoleResourcePermission">
    			<id property="id" column="pid"/>
    			<result property="resourceId" column="resource_id" />
    			<result property="permissionIds" column="permission_ids"/>
    			<association property="role" javaType="Role" />
    		</collection>
    	</resultMap>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 