<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Mcgrady</title>
    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
    <link href="${ctx}/static/css/plugins/switchery/switchery.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${ctx}/static/plugin/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    <script>var ctx ='${ctx}',uid ='${user.id}';</script>

    <SCRIPT LANGUAGE="JavaScript">

    </SCRIPT>


</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="">

        <div class="tabs-container">


                <%--start navigate button--%>

                <%--navigate button--%>

                <div class="tab-content" id="optionDiv">
                    <%--list div start--%>
                    <div id="tab-1" class="tab-pane active" >
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="ibox float-e-margins">

                                    <div class="ibox-content">

                                        <div class="">
                                            <%--<a onclick="" href="javascript:void(0);" class="btn btn-primary" style="">添加用户</a><br><br>--%>

                                            <%----%>
                                            <form role="form" class="form-inline" id="searchForm">
                                                <div class="form-group" style="margin-left:50px">
                                                    <span>用户：</span><label for="username"
                                                                            class="sr-only">用户</label>
                                                    <input name="username" type="text" id="username"
                                                           class="form-control">
                                                </div>

                                                <div class="form-group" style="margin-left:50px">
                                                    <span>模块：</span><label for="module"
                                                                           class="sr-only">模块</label>
                                                    <input name="module" type="text" id="module"
                                                           class="form-control">
                                                </div>

                                                <div class="form-group" style="margin-left:50px">
                                                    <span>IP：</span><label for="ip"
                                                                           class="sr-only">IP</label>
                                                    <input name="ip" type="text" id="ip"
                                                           class="form-control">
                                                </div>



                                                <div class="form-group" style="margin-left:50px">
                                                    <span>开始时间：</span><label for="start_time"
                                                                             class="sr-only">开始时间</label>
                                                    <input name="start_time" type="text" id="start_time"
                                                           class="form-control">
                                                </div>

                                                <div class="form-group" style="margin-left:50px">
                                                    <span>结束时间：</span><label for="end_time"
                                                                             class="sr-only">结束时间</label>
                                                    <input name="end_time" type="text" id="end_time"
                                                           class="form-control">
                                                </div>

                                                <a onclick="" href="javascript:void(0);" class="btn btn-info "
                                                   id="search-btn"
                                                   style="float: right">查询</a>

                                            </form>
                                        </div>

                                        <br/><br/>
                                        <table class="table table-striped table-bordered table-hover dataTables-example"
                                               id="list" >
                                            <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>排序号</th>
                                                <th>用户</th>
                                                <th>模块</th>
                                                <th>操作描述</th>
                                                <th>内容</th>
                                                <th>IP地址</th>
                                                <th>操作时间</th>
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
                    </div>


                </div>

        </div>
    </div>
</div>
<script src="${ctx}/static/js/plugins/jeditable/jquery.jeditable.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="${ctx}/static/js/plugins/switchery/switchery.js"></script>

<script src="${ctx}/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/static/js/demo/form-validate-demo.min.js"></script>

<script src="${ctx}/static/js/demo/form-validate-demo.min.js"></script>

<script src="${ctx}/static/plugin/laydate/laydate.js"></script>

<script src="${ctx}/static/plugin/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>

<script src="${ctx}/static/js/customer/system/log/log.js"></script>
<script>
    $(document).ready(function () {

        //初始化新增页面时间框
        laydate.render({
            elem: '#start_time', //指定元素
            type: 'datetime'
        });

        laydate.render({
            elem: '#end_time', //指定元素
            type: 'datetime'
        });

        //初始化datatables
        Table.initTa();
    });

</script>
</body>
</html>
