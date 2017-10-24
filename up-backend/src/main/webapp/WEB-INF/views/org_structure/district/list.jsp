<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Treetable Plugin</title>
    <link rel="shortcut icon" href=""/>
    <link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.min.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->

    <style>
        .pagination {
            margin: 0;
        }
    </style>
</head>

<body>
<BR><BR>


<div class="row">

    <div class="col-xs-12" role="main">
        <div class="panel panel-default">

            <div class="panel-body form-horizontal">

                <div class="form-group">
                    <!--<label class="col-xs-2 control-label">-->
                    <!--目录名称：-->
                    <!--</label>-->

                    <div class="col-xs-4" data-toggle="popover" data-trigger="focus" data-content="请输入20位有效字符">
                        <div class="input-group ">
                            <input type="text" id="serachvalue" class="form-control" placeholder="请输入查询条件">
                            <span class="input-group-btn">
			                                            <button class="btn btn-default form-control" type="button"
                                                                id="serach">查询
                                                        </button>
			                                          </span>
                        </div>
                    </div>


                    <div class="col-xs-8 text-right">


                        <button type="button" class="btn btn-primary" id="destroy">注销
                        </button>
                        <button type="button" class="btn btn-primary" id="reset">初始化
                        </button>
                        <button type="button" class="btn btn-primary" id="expendAll">全部展开
                        </button>
                        <button type="button" class="btn btn-primary" id="collapseAll">全部关闭
                        </button>
                    </div>
                </div>

                <nav class="pull-right">
                    <ul class="pagination">

                    </ul>
                </nav>

                <table class="table table-hover table-condensed " id="treetable">
                    <thead class="bg-default">
                    <tr>
                        <th  >
                            目录名称
                        </th>
                        <th data-column-id="auditstatedesc" style="width:150px"  >
                            编码
                        </th>
                        <th style="width:150px"  >
                            是否有效
                        </th>
                        <th data-column-id="item_type" data-sortable="false" style="width:150px"  >
                            叶子节点
                        </th>
                        <th data-column-id="auditstatedesc" style="width:100px">
                            操作
                        </th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:choose>
                        <c:when test="${empty list}">


                        </c:when>
                        <c:otherwise>
                            <c:forEach var="dis" items="${list}">

                                <tr data-id="${dis.code}" data-pid="${dis.parentCode}">
                                    <td  style="width:150px">
                                            ${dis.name}
                                    </td>

                                    <td  style="width:150px">${dis.code}</td>
                                    <td  style="width:150px">


                                            ${dis.is_show==1 ?'是':'否'}

                                    </td>
                                    <th data-column-id="auditstatedesc" style="width:150px">
                                            ${dis.is_leaf==1 ?'是':'否'}
                                    </th>

                                    <td ><a href="#" class="doedit">编辑</a> <a href="#" class="dodel">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </c:otherwise>

                    </c:choose>


                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

</div>
<footer>
    <div class="container">
        <hr>
        <br>

        <p class="pull-right"><a href="#"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span> Back to top</a></p>

        <p class="text-center">
            &copy;<a href="https://gitee.com/harris992/JQuery-TreeTable-Plugin.git" target="_blank">JQuery-TreeTable-Plugin</a>
        </p>
        <br>
    </div>
</footer>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Edit</h4>
            </div>
            <div class="modal-body">
            </div>
        </div>
    </div>
</div>

<script src="${ctx}/static/js/bootstrap-treetable.js"></script>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="${ctx}/static/js/customer/district/district.js"></script>

<script>
 $(function () {
     $('#treetable').BootstrapTreeTable('reset');
 })
</script>
</body>
</html>



