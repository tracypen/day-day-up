<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Mcgrady</title>
    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
    <link href="${ctx}/static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <!-- Morris -->
    <link href="${ctx}/static/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="${ctx}/static/plugin/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/switchery/switchery.css" rel="stylesheet">

</head>
<body class="gray-bg">
<input id="typeCode" type="hidden">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-6" style="width: 30%">


            <div class="ibox-content">

                <div class="" style="display: none">
                    <a href="javascript:void(0);" class="btn btn-info " id="search-type-btn"
                       style="display: none">查询</a>
                </div>
                <span style="font-size: 14px"><b>角色信息树</b></span>
                <a href="javascript:void(0);" class="btn btn-primary" style="float: right" title="新增资源"><span
                        class="glyphicon glyphicon-plus" aria-hidden="true"></span></a><br><br>
                <div class="ztree" id="ztree"></div>
            </div>

        </div>


        <%--右侧页面--%>
        <div class="col-sm-6" style="width: 70%;" id="rightDiv">

        </div>
    </div>
</div>
<script src="${ctx}/static/js/plugins/jeditable/jquery.jeditable.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="${ctx}/static/plugin/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
<script src="${ctx}/static/js/plugins/switchery/switchery.js"></script>

<script src="${ctx}/static/js/customer/system/resources/resources.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script>
    $(document).ready(function () {
        //初始化ztree菜单
        initZtree();
    });

</script>
</body>

</html>