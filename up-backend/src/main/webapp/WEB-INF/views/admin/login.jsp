<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <link href="${ctx}/static/css/style.min.css?v=4.0.0" rel="stylesheet">
    <%--<base target="_blank">--%>
    <script>
        if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>
<%--<jsp:forward page="${ctx}/admin/index?status=1" />--%>

<script>
<shiro:user>
   window.location.href="${ctx}/admin/index?status=1";
</shiro:user>
</script>
<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">H+</h1>

        </div>
        <h3>登录</h3>

        <form class="m-t" role="form" method="post" action="${ctx}/admin/login">
            <div class="form-group">
                <input type="text" name="username" value="mcgrady" class="form-control" placeholder="用户名"
                       required="required">
            </div>
            <div class="form-group">
                <input type="password" name="password" value="111111" class="form-control" placeholder="密码"
                       required="required">
            </div>

            <div class="form-group">
                <input type="text" name="vaildateCode" class="form-control" placeholder="验证码" required="required">

                <img src="${ctx}/static/images/kaptcha.jpg"/><a id="verifyCodeImg" href="javascript:void(0)">换一张</a>

            </div>

            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center"><a href="login.html#">
                <small>忘记密码了？</small>
            </a> | <a href="register.html">注册一个新账号</a>
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
            var src = '${ctx}/static/images/kaptcha.jpg?t=' + Math.random();
            //alert(src)
            $(this).siblings('img').attr('src', src);
        });

    });

</script>

</body>

</html>




