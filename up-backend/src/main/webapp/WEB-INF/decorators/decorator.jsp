
<%@ page language="java" contentType="text/html; charset=utf-8"

         pageEncoding="utf-8"%>


<%--<%@taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<meta charset="UTF-8">
<head>

<title>
    <sitemesh:write property='title' /> - ltcms
</title>
<sitemesh:write property='head' />
</head>
<body>
    <header>1234</header>
    <hr />
    demo.html  title
    <sitemesh:write property='title' /><br />
    demo.html  body
    <sitemesh:write property='body' />
    <hr />
    <footer>footersd20170523</footer>
</body>
</html>