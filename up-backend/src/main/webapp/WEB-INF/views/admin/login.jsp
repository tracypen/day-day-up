<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
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
    });--%>


    <html>

    <head>

    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <title>登录</title>
        <meta name="keywords" content="H+后台主题">
        <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题">

        <link rel="shortcut icon" href="${ctx}static/img/favicon.ico">
        <link href="${ctx}/static/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
        <link href="${ctx}/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

        <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
        <link href="${ctx}/static/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
        <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">H+</h1>

        </div>
        <h3>登录</h3>

        <form class="m-t" role="form" method="post" action="${ctx}/admin/login">
            <div class="form-group">
                <input type="text" name="username" value="mcgrady" class="form-control" placeholder="用户名" required = "required">
            </div>
            <div class="form-group">
                <input type="password" name="password" value="111111" class="form-control" placeholder="密码" required="required">
            </div>

            <div class="form-group">
                <input type="text" name="vaildateCode" class="form-control" placeholder="验证码" required="required">

                <img  src="${ctx}/static/images/kaptcha.jpg"/><a id="verifyCodeImg"
                    href="javascript:void(0)">换一张</a>

            </div>

            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
            </p>

        </form>
    </div>
</div>
<script src="${ctx}/static/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.3.5"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

<script>

    $(function () {
        $('#verifyCodeImg').click(function () {
            var $this = $(this);
            var src ='${ctx}static/images/kaptcha.jpg?t='+Math.random();
            $this.attr('src', src);
        });

    });

</script>

</body>

</html>




