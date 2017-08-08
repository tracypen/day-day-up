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

    <input type="text" name="name" value="" placeholder="请输入用户名"><br>
    <input type="password" name="password" value="" placeholder="请输入密码"><br>
    <input type="submit" value=" 登录" >


</form>
</body>
</html>
