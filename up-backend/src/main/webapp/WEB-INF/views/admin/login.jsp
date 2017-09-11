<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<html>
<head>
    <title>用户登录 ${ctx}</title>
    <link rel="stylesheet" type="text/css"
          href="${ctx}/static/plugin/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/static/icons/icons.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/static/plugin/easyui/themes/icon.css">
    <script type="text/javascript"
            src="${ctx}/static/plugin/jquery/jquery-1.11.3.min.js"></script>
    <script type="text/javascript"
            src="${ctx}/static/plugin/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${ctx}/static/plugin/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/static/plugin/seajs/sea.js"></script>
</head>
<body style="padding: 0;margin: 0;">
<img src="${ctx}/static/images/timg.jpg" width="100%" height="100%">
<div id="login-dialog" class="easyui-dialog" title="登录" style="width:400px;height:auto;"
     data-options="iconCls:'icon-login-user',resizable:false,modal:false,closable:false,draggable:false">
    <form id="login-form" method="post" action="<%=basePath%>admin/login">
        <div style="width: 300px;margin: 20px auto 20px;">
            <input class="easyui-textbox" name="username"
                   data-options="iconCls:'icon-account',iconAlign:'left',prompt:'账号',required:true,validType:'account[3,20]',missingMessage:'请输入账号',value:'admin'"
                   style="width:300px;height: 30px;">
        </div>
        <div style="width: 300px;margin: 20px auto 20px;">
            <input class="easyui-textbox" name="password" value="111111"
                   data-options="type:'password',iconCls:'icon-pwd',iconAlign:'left',prompt:'密码',required:true,validType:'password[6,20]',missingMessage:'请输入密码',value:'123456'"
                   style="width:300px;height: 30px;">
        </div>
        <div style="width: 300px;margin: 20px auto 20px;">
            <input class="easyui-textbox" name="vaildateCode"
                   data-options="iconCls:'icon-yanzhengma',iconAlign:'left',prompt:'验证码',required:true,validType:'verifycode[4]',missingMessage:'请输入验证码'"
                   style="width:300px;height: 30px;">
        </div>
        <div style="width: 300px;margin: 20px auto 20px;">
            <img id="verifyCodeImg"/><a
                href="javascript:void(0)">换一张</a>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    $(function () {
        seajs.config({
            base: "${ctx}/static/js/",
            alias: {

            }
        });
        //加载首页
        seajs.use(['base', 'user/login'], function (b, login) {
            b.init();
            login.init('<%=basePath%>');
        });
    });

</script>