<%--
  Created by IntelliJ IDEA.
  User: 郝鹏
  Date: 2017/9/3
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>管理后台</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugin/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugin/easyui/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/plugin/jquery/jquery-1.11.3.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/plugin/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/plugin/seajs/sea.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/plugin/seajs/standalone-debug.js"></script>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/icons/icons.css">

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=cTYtHPV1spdnWgFSeKfXqjTh"></script>


</head>

<body class="easyui-layout">
<div data-options="region:'north',title:'',split:false,collapsible:false,border:false" style="height:100px;background-color: #30aee8;">
    <div style="margin-top: 30px;padding-left: 50px;">
        <span style="font-size: 20px;color: white;">Mcgrady权限管理系统</span>
        <a href="${pageContext.request.contextPath}/logout.action" class="easyui-linkbutton" iconCls="icon-tuichu"
           style="float: right;margin-right: 50px;" plain="true">退出</a>
        <a id="message-board-button" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-liuyanfankui"
           style="float: right;margin-right: 30px;" plain="true">留言板</a>
    </div>

    <div id="main-message-board-dialog"  title="留言板" style="width:500px;height:400px;display: none;"
         data-options="iconCls:'icon-liuyanfankui',resizable:false,modal:true">
        <textarea style="width: 100%;height: 323px;resize: none;"></textarea>
    </div>
   <%-- <shiro:hasPermission name="permission:delete">--%>
        <span id="basejs_permission_del" style="display: none;"/>
   <%-- </shiro:hasPermission>
    <shiro:hasPermission name="permission:edit">--%>
        <span id="basejs_permission_edit" style="display: none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="permission:add">--%>
        <span id="basejs_permission_create" style="display:none;"/>
  <%--  </shiro:hasPermission>
    <shiro:hasPermission name="permission:check">--%>
        <span id="basejs_permission_check" style="display:none;"/>
<%--    </shiro:hasPermission>

    <shiro:hasPermission name="menu:edit">--%>
        <span id="basejs_menu_edit" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="menu:delete">--%>
        <span id="basejs_menu_del" style="display:none;"/>
    <%--</shiro:hasPermission>
    <shiro:hasPermission name="menu:add">--%>
        <span id="basejs_menu_create" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="menu:check">--%>
        <span id="basejs_menu_check" style="display:none;"/>
   <%-- </shiro:hasPermission>
    <shiro:hasPermission name="menupermisson:check">--%>
        <span id="basejs_menu_permission_check" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="menu:grant">--%>
        <span id="basejs_menu_grant" style="display:none;"/>
  <%--  </shiro:hasPermission>


    <shiro:hasPermission name="role:add">--%>
        <span id="basejs_role_create" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="role:delete">--%>
        <span id="basejs_role_del" style="display:none;"/>
   <%-- </shiro:hasPermission>
    <shiro:hasPermission name="role:edit">--%>
        <span id="basejs_role_edit" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="role:grant">--%>
        <span id="basejs_role_grant" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="rolepermission:check">--%>
        <span id="basejs_role_permission_check" style="display:none;"/>
 <%--   </shiro:hasPermission>
    <shiro:hasPermission name="role:check">--%>
        <span id="basejs_role_check" style="display:none;"/>
<%--    </shiro:hasPermission>

    <shiro:hasPermission name="dep:add">--%>
        <span id="basejs_department_create" style="display:none;"/>
  <%--  </shiro:hasPermission>
    <shiro:hasPermission name="dep:delete">--%>
        <span id="basejs_department_del" style="display:none;"/>
<%--    </shiro:hasPermission>
    <shiro:hasPermission name="dep:edit">--%>
        <span id="basejs_department_edit" style="display:none;"/>
<%--    </shiro:hasPermission>


    <shiro:hasPermission name="user:add">--%>
        <span id="basejs_user_create" style="display:none;"/>
  <%--  </shiro:hasPermission>
    <shiro:hasPermission name="user:check">--%>
        <span id="basejs_user_check" style="display:none;"/>
  <%--  </shiro:hasPermission>
    <shiro:hasPermission name="user:edit">--%>
        <span id="basejs_user_edit" style="display:none;"/>
 <%--   </shiro:hasPermission>
    <shiro:hasPermission name="user:delete">--%>
        <span id="basejs_user_del" style="display:none;"/>
 <%--   </shiro:hasPermission>

    <shiro:hasPermission name="distribute:role">--%>
        <span id="basejs_user_distribute_role" style="display:none;"/>
 <%--   </shiro:hasPermission>
    <shiro:hasPermission name="edituser:dep">--%>
        <span id="basejs_user_edit_dep" style="display:none;"/>
<%--    </shiro:hasPermission>--%>


</div>
<div data-options="region:'west',title:'导航',split:false,iconCls:'icon-daohang'" style="width:200px;padding: 5px;">
    <ul id="navigation-menu"></ul>
</div>
<div data-options="region:'center',title:''">
    <div id="center-content" class="easyui-tabs" fit="true" plain="true">
        <div title="欢迎页" iconCls="icon-huanying" href="${pageContext.request.contextPath}/admin/welcomePage" style="padding: 5px;">
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    seajs.config({
        base: "${pageContext.request.contextPath}/assets/js/",
        alias: {
            'baidumap1':'http://api.map.baidu.com/api?v=2.0&ak=cTYtHPV1spdnWgFSeKfXqjTh',
            'baidumap2':'http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js',
            'baidumap3':'http://api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js'
        }
    });
    //加载首页
    seajs.use(['base', 'main/index'], function (base, index) {
        if ($('#basejs_permission_del').length > 0) {
            base.perList.permission.del = true;
        }
        if ($('#basejs_permission_edit').length > 0) {
            base.perList.permission.edit = true;
        }
        if ($('#basejs_permission_create').length > 0) {
            base.perList.permission.create = true;
        }
        if ($('#basejs_permission_check').length > 0) {
            base.perList.permission.check = true;
        }
        if ($('#basejs_menu_edit').length > 0) {
            base.perList.menu.edit = true;
        }
        if ($('#basejs_menu_del').length > 0) {
            base.perList.menu.del = true;
        }
        if ($('#basejs_menu_create').length > 0) {
            base.perList.menu.create = true;
        }
        if ($('#basejs_role_create').length > 0) {
            base.perList.role.create = true;
        }
        if ($('#basejs_role_del').length > 0) {
            base.perList.role.del = true;
        }
        if ($('#basejs_role_edit').length > 0) {
            base.perList.role.edit = true;
        }
        if ($('#basejs_department_create').length > 0) {
            base.perList.department.create = true;
        }
        if ($('#basejs_department_del').length > 0) {
            base.perList.department.del = true;
        }
        if ($('#basejs_department_edit').length > 0) {
            base.perList.department.edit = true;
        }
        if ($('#basejs_role_grant').length > 0) {
            base.perList.role.grant = true;
        }
        if ($('#basejs_role_permission_check').length > 0) {
            base.perList.role.checkPermission = true;
        }
        if ($('#basejs_role_check').length > 0) {
            base.perList.role.check = true;
        }
        if ($('#basejs_menu_check').length > 0) {
            base.perList.menu.check = true;
        }
        if ($('#basejs_menu_permission_check').length > 0) {
            base.perList.menu.checkPermission = true;
        }
        if ($('#basejs_menu_grant').length > 0) {
            base.perList.menu.grant = true;
        }
        if ($('#basejs_user_create').length > 0) {
            base.perList.user.create = true;
        }
        if ($('#basejs_user_check').length > 0) {
            base.perList.user.check = true;
        }
        if ($('#basejs_user_edit').length > 0) {
            base.perList.user.edit = true;
        }
        if ($('#basejs_user_del').length > 0) {
            base.perList.user.del = true;
        }
        if ($('#basejs_user_distribute_role').length > 0) {
            base.perList.user.distribute_role = true;
        }
        if ($('#basejs_user_edit_dep').length > 0) {
            base.perList.user.edit_dep = true;
        }
        index.init('${ctx}');
    });
</script>













<%--<html>
<head>
    <title>Title</title>
</head>
<body>

<shiro:authenticated>
    hello： <shiro:principal type="com.hp.up.backend.shiro.UserShiro" property="name"></shiro:principal>
</shiro:authenticated>
<br>
<a href="${ctx}/logout.action">退出</a>
</body>
</html>--%>


