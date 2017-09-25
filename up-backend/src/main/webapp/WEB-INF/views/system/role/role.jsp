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
    <link href="${ctx}/static/plugin/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
</head>
<body class="gray-bg">
<input id="typeCode" type="hidden" >
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-6" style="width: 30%">

            <%--字典类型--%>
            <div class="ibox-content">

                <div class="" style="display: none">
                    <a  href="javascript:void(0);" class="btn btn-info " id="relode_btn"
                       style="display: none">查询</a>
                </div>
                     <span>角色信息列表</span>
                    <a  href="${ctx}/system/role/saveOrUpdate" class="btn btn-primary" style="float: right" title="新增角色"><span class="glyphicon glyphicon-plus" aria-hidden="true" ></span></a><br><br>
                    <table class="table table-striped table-bordered table-hover dataTables-example" id="role-list">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>排序号</th>
                        <th>角色名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>

                </table>

            </div>

        </div>


        <div class="col-sm-6" style="width: 30%;" id="addEditDiv">
            <form class="form-horizontal m-t" id="addForm" action="/">
                <div class="form-group">
                    <label class="col-sm-3 control-label">角色名称：</label>
                    <div class="col-sm-8">
                        <input id="name" name="name" class="form-control" type="text" readonly
                               style="width: 50%">
                        <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">角色标识：</label>
                    <div class="col-sm-8">
                        <input id="role" name="role" class="form-control" readonly
                               type="text"
                               aria-required="true" aria-invalid="false" class="valid"
                               style="width: 50%">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">角色描述：</label>
                    <div class="col-sm-8">
                        <input id="description" name="description" class="form-control" readonly
                               type="text"
                               aria-required="true" aria-invalid="false" class="valid"
                               style="width: 50%">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">角色类型：</label>
                    <div class="col-sm-8">
                        <input id="typeName" name="typeName" class="form-control" type="email" readonly
                               style="width: 50%">
                    </div>
                </div>

            </form>


        </div>
        <div class="col-sm-6" style="width: 40%;" id="treeDiv">
            <!--tree-->
            <div class="col-sm-2 ui-sortable">
                <a id="save_btn"  href="javascript:void(0);" class="btn btn-info" style="margin-left: 120px; display: none"  title="保存"><span class="glyphicon glyphicon-file" aria-hidden="true" ></span></a>
               <br>
                <div id="treeDemo" class="ztree"></div>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/plugins/jeditable/jquery.jeditable.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="${ctx}/static/plugin/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
<script src="${ctx}/static/plugin/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>

<script src="${ctx}/static/js/customer/system/role/role.js"></script>
<%--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>--%>
<script>
    $(document).ready(function () {

        //加载datTables
        roleTable.initTa();

    });

</script>
</body>

</html>