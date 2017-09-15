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
                            <input name="name" type="text" id="exampleInputEmail3" class="form-control">
                        </div>
                        <a onclick="" href="javascript:void(0);" class="btn btn-info " id="search-btn"
                           style="float: right">查询</a>
                    </form>
                </div>


                <table class="table table-striped table-bordered table-hover dataTables-example" id="dic_list">
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


        <div class="col-sm-6">
            <div class="ibox-content">

                <div class="">
                    <a onclick="" href="javascript:void(0);" class="btn btn-primary" style="">添加</a><br><br>
                </div>


                <table class="table table-striped table-bordered table-hover dataTables-example" id="dic_type_list">
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
                    <%-- <c:if test="${not empty pagination.data}">
                         <c:forEach items="${pagination.data }" var="user" varStatus="st">
                             <tr>
                                 <td>${(pagination.paging.pageNum-1) * pagination.paging.pageSize + st.count}</td>
                                 <td>${user.name}</td>
                                 <td>${user.userRealName}</td>
                                 <td>${user.email}</td>
                                 <td><fmt:formatDate value="${user.birthday}"
                                                     pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                 <td>${user.active.info}</td>

                                 <td>
                                     <a title="编辑"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                     &nbsp;&nbsp;&nbsp;
                                     <a title="删除" href="javascript:void(0);" onclick="delUser('${user.id}')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                 </td>
                             </tr>
                         </c:forEach>

                     </c:if>--%>
                    </tbody>
                    <%--    <tfoot>
                        <tr>
                            <th>渲染引擎</th>
                            <th>浏览器</th>
                            <th>平台</th>
                            <th>引擎版本</th>
                            <th>CSS等级</th>
                        </tr>
                        </tfoot>--%>
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
</body>

</html>