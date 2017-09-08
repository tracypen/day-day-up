<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<html>
<head>
    <title>登录</title>
    <script src="<%=basePath%>static/plugin/jquery/jquery-1.11.3.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style type="text/css">
        .vertical-center{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
</head>
<%--<body>--%>
<%--<h5>admin index </h5>--%>

<%--<p>登录</p>--%>
<%--<form action="<%=basePath%>index/login" method="post" name="" id="">--%>

    <%--用户名：<input type="text" name="name"  placeholder="请输入用户名"> &nbsp;&nbsp;<em style="color: crimson">${msg}</em> <br>--%>
    <%--密码： <input type="password" name="password"  placeholder="请输入密码"><br>--%>
    <%--验证码：<input type="text" name="vaildateCode" placeholder="验证码"/>  <img src="<%=basePath%>/static/images/kaptcha.jpg"><br>--%>
    <%--<input type="submit" value=" 登录" >--%>

<%--</form>--%>
<%--</body>--%>

<body>
<div class="container vertical-center">
    <div class="col-md-6 col-md-offset-3">
        <form  action="<%=basePath%>admin/login" method="post">
            <h2 >登录</h2><em style="color: crimson">${msg}</em>
            <label for="name" class="sr-only">userid</label>
            <input type="text" name="username" id="name" class="form-control" placeholder="请输入用户名" required autofocus>
            <label for="password" class="sr-only">Password</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" required>
            <label for="vaildateCode" class="sr-only">vaildateCode</label>
            <input type="text" name="vaildateCode" id="vaildateCode" class="form-control" placeholder="验证码" required>
            验证码： <img id="img" src="<%=basePath%>static/images/kaptcha.jpg" width="120" height="40" onclick="changeImg();">
            <button class="btn btn-lg btn-primary btn-block" type="submit">login</button>
        </form>

    </div>
</div> <!-- /container -->
</body>


<script>
    function changeImg() {
        $('#img').attr('src','<%=basePath%>static/images/kaptcha.jpg?t='+Math.random())
    }
</script>
</html>
