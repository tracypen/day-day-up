<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>admin index </h5>

<p>登录</p>
<form action="<%=basePath%>index/login" method="post" name="" id="">

    用户名：<input type="text" name="name"  placeholder="请输入用户名"> &nbsp;&nbsp;<em style="color: crimson">${msg}</em> <br>
    密码： <input type="password" name="password"  placeholder="请输入密码"><br>
    验证码：<input type="text" name="vaildateCode" placeholder="验证码"/>  <img src="<%=basePath%>/static/images/kaptcha.jpg"><br>
    <input type="submit" value=" 登录" >

</form>
</body>

<script>

</script>
</html>
