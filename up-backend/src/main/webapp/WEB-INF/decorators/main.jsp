<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title><decorator:title/></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <%@include file="/WEB-INF/views/common/import-css-js.jspf" %>
    <decorator:head />
    <link rel="shortcut icon" href="favicon.ico">
</head>
<%--<decorator:head/>--%>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">


<div id="wrapper">
    <%@include file="/WEB-INF/decorators/menu.jsp" %>
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <%@include file="/WEB-INF/decorators/search.jsp" %>
            <div class="row J_mainContent" id="content-main">
                <decorator:body/>
            </div>
            <%@include file="/WEB-INF/decorators/footer.jsp" %>
        </div>
</div>
<decorator:getProperty property="page.script"/>
<decorator:getProperty property="page.css"/>

</body>
</html>