<%--
  Created by IntelliJ IDEA.
  User: 郝鹏
  Date: 2017/9/3
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
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
</html>
