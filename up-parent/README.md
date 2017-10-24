# up-parent
 父级项目 聚合

111111 salt 123456
81255cb0dca1a5f304328a70ac85dcbd

datatables url
http://localhost:8080/dictionaryType/dictionary/1001/list?now=1505466957845&&sEcho=2&iColumns=6&sColumns=%2C%2C%2C%2C%2C&iDisplayStart=0&iDisplayLength=15&mDataProp_0=id&bSortable_0=true&mDataProp_1=name&bSortable_1=true&mDataProp_2=name&bSortable_2=true&mDataProp_3=code&bSortable_3=true&mDataProp_4=id&bSortable_4=true&mDataProp_5=id&bSortable_5=true&iSortCol_0=4&sSortDir_0=asc&iSortingCols=1


iSortCol_0=1&sSortDir_0=asc

DataProp_0=id



1.引入ios风格按钮
<link href="${ctx}/static/css/plugins/switchery/switchery.css" rel="stylesheet">
<script src="${ctx}/static/js/plugins/switchery/switchery.js"></script>
 //初始化ios风格按钮
        var elem = document.querySelector('.js-switch');
        var init = new Swit chery(elem);

2.引入弹窗插件
<link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>

 function delUser(id) {
     swal({
         title: "您确定要删除这条信息吗",
         text: "删除后将无法恢复，请谨慎操作！",
         type: "warning",
         showCancelButton: true,
         confirmButtonColor: "#DD6B55",
         confirmButtonText: "是的，我要删除！",
         cancelButtonText: "让我再考虑一下…",
         closeOnConfirm: false,
         closeOnCancel: false
     }, function (isConfirm) {
         if (isConfirm) {
             $.ajax({
                 url: ctx + "/user/" + id + "/delete",
                 type:'post',
                 data: id,
                 dataType: 'json',
                 async: true,
                 success: function (msg) {
                    // swal({title: "操作成功", text: "数据已经删除", type: "success"});
                     //window.location.href = ctx+'/user/list';
                     if (msg.code == 10001){
                         swal("删除成功！", "您已经永久删除了这条信息。", "success");
                         $("#search-btn").click();
                     }else{
                         swal("删除失败！", "请稍后尝试！", "error");
                     }
                 }
             });
 
         } else {
             swal("已取消", "您取消了删除操作！", "error");
         }
     })
 
 }
 
 
 
 听音乐
 http://www.sojson.com/other/music.html
 天气
 http://www.sojson.com/blog/234.html
 
 
 
 
 
 

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
 
 3. springboot 最佳实战 https://github.com/ChinaSilence/any-video
 
 4. springboot +websocket 及时聊天室 https://github.com/ChinaSilence/any-chat.git
 
 Spring Boot实战项目
 http://git.oschina.net/roncoocom/roncoo-jui-springboot
 
 Spring Boot教程代码
 http://git.oschina.net/roncoocom/spring-boot-demo
 

 
 
 
 
 
 
 
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
 
 
 
 
 
 
 
 
 <div class="row J_mainContent" id="content-main">
 
 
 
 
 
 
 模态窗
 
  <script>var ctx = '${ctx}', uid = '${user.id}', is_logined = '${status}';</script>
 
 <script type="text/javascript">
 
     if (is_logined) {
         $("#loginModal").modal('show');
         setTimeout(function(){
             $("#loginModal").modal('hide');
         },1000)
     }
 
 </script>
 
 <!-- Modal -->
 <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                 </button>
                 <h4 class="modal-title" id="myModalLabel">提示</h4>
             </div>
             <div class="modal-body">
                您已登录！
             </div>
           <%--  <div class="modal-footer">
                 <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                 <button type="button" class="btn btn-primary">Save changes</button>
             </div>--%>
         </div>
     </div>
 </div>
 