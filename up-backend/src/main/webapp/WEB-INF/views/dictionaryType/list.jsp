<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
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
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-6">

            <%--字典类型--%>
            <div class="ibox-content">

                <div class="">
                    <a onclick="" href="javascript:void(0);" class="btn btn-primary" style="">添加</a><br><br>

                    <%----%>
                    <form role="form" class="form-inline" id="searchForm">
                        <div class="form-group" style="margin-left:50px">
                            <span>类型名称：</span><label for="exampleInputEmail2" class="sr-only">类型名称</label>
                            <input name="name" type="text" id="exampleInputEmail2" class="form-control">
                        </div>
                        <div class="form-group" style="margin-left:50px">
                            <span>类型编号：</span><label for="exampleInputEmail3" class="sr-only">类型编号</label>
                            <input name="code" type="text" id="exampleInputEmail3" class="form-control">
                        </div>
                        <a onclick="" href="javascript:void(0);" class="btn btn-info " id="search-btn"
                           style="float: right">查询</a>
                    </form>
                </div>


                <table class="table table-striped table-bordered table-hover dataTables-example" id="dic_type_list">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>排序号</th>
                        <th>类型名称</th>
                        <th>类型编码</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>

                </table>

            </div>

        </div>


        <div class="col-sm-6" style="display: none;">
            <div class="ibox-content">

                <div class="">
                    <a onclick="" href="javascript:void(0);" class="btn btn-primary" style="">添加</a><br><br>
                </div>


                <table class="table table-striped table-bordered table-hover dataTables-example" id="dic_list">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>所属类型</th>
                        <th>字典名称</th>
                        <th>字典编号</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/plugins/jeditable/jquery.jeditable.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

<script src="${ctx}/static/js/dictionaryType/dictionaryType.js"></script>
<script>
    $(document).ready(function () {
        Type_Table.initTa();
    });

</script>
</body>

</html>