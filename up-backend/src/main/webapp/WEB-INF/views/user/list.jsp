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
            <!--left tree-->
            <div class="col-sm-2 ui-sortable" style=" width:15%">
                <div id="treeDemo" class="ztree"></div>
            </div>

            <%--right body--%>
            <div class="col-sm-10 ui-sortable" style=" width:85%">

                <%--start navigate button--%>
                <ul class="nav nav-tabs">
                    <li id="listLi" class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true"> 用户列表</a>
                    </li>
                    <li id="addLi"><a data-toggle="tab" href="#tab-2" aria-expanded="false">新增用户</a></li>

                    <li id="editLi" style="display: none"><a data-toggle="tab" href="#tab-3"
                                                             aria-expanded="false">修改用户</a>
                    </li>
                </ul>
                <%--navigate button--%>

                <div class="tab-content" id="optionDiv">
                    <%--list div start--%>
                    <div id="tab-1" class="tab-pane active">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="ibox float-e-margins">

                                    <div class="ibox-content">

                                        <div class="">
                                            <%--<a onclick="" href="javascript:void(0);" class="btn btn-primary" style="">添加用户</a><br><br>--%>

                                            <%----%>
                                            <form role="form" class="form-inline" id="searchForm">
                                                <div class="form-group" style="margin-left:50px">
                                                    <span>用户名：</span><label for="exampleInputEmail2"
                                                                            class="sr-only">用户名</label>
                                                    <input name="name" type="text" id="exampleInputEmail2"
                                                           class="form-control">
                                                </div>
                                                <div class="form-group" style="margin-left:50px">
                                                    <span>性别：</span><select class="form-control" name="gender">
                                                    <option value="">-请选择-</option>
                                                    <option value="1">男</option>
                                                    <option value="2">女</option>
                                                </select>
                                                </div>
                                                <a onclick="" href="javascript:void(0);" class="btn btn-info "
                                                   id="search-btn"
                                                   style="float: right">查询</a>
                                                <input type="checkbox" class="js-switch" checked/>
                                            </form>
                                        </div>


                                        <table class="table table-striped table-bordered table-hover dataTables-example"
                                               id="list">
                                            <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>排序号</th>
                                                <th>登录名</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>手机号</th>
                                                <th>邮箱</th>
                                                <th>生日</th>
                                                <th>状态</th>
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

                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--end list div--%>
                    <%--add div satrt--%>
                    <div id="tab-2" class="tab-pane">
                        <div class="">
                            <div class="ibox float-e-margins">

                                <div class="ibox-content">
                                    <form class="form-horizontal m-t" id="addForm" action="/">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">用户名：</label>
                                            <div class="col-sm-8">
                                                <input id="name" name="name" class="form-control" type="text"
                                                       style="width: 50%">
                                                <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">真实姓名：</label>
                                            <div class="col-sm-8">
                                                <input id="userRealName" name="userRealName" class="form-control"
                                                       type="text"
                                                       aria-required="true" aria-invalid="false" class="valid"
                                                       style="width: 50%">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">性别：</label>
                                            <div class="col-sm-8" id="gender">
                                                <div class="radio radio-info radio-inline">
                                                    <input type="radio" id="inlineRadio1" value="1" name="gender"
                                                           checked>
                                                    <label for="inlineRadio1"> 男 </label>
                                                </div>
                                                <div class="radio radio-inline">
                                                    <input type="radio" id="inlineRadio2" value="2" name="gender">
                                                    <label for="inlineRadio2"> 女 </label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">手机号：</label>
                                            <div class="col-sm-8">
                                                <input id="phone" name="phone" class="form-control" type="text"
                                                       style="width: 50%">
                                                <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">密码：</label>
                                            <div class="col-sm-8">
                                                <input id="password" name="password" class="form-control"
                                                       type="password"
                                                       style="width: 50%">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">确认密码：</label>
                                            <div class="col-sm-8">
                                                <input id="confirm_password" name="confirm_password"
                                                       class="form-control"
                                                       type="password" style="width: 50%">
                                                <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>--%>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">QQ：</label>
                                            <div class="col-sm-8">
                                                <input id="qq" name="qq" class="form-control" type="text"
                                                       style="width: 50%">
                                                <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">生日：</label>
                                            <div class="col-sm-8">
                                                <input id="birthday" id="birthday" name="birthday" type="text"
                                                       class="form-control" style="width: 50%">

                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">E-mail：</label>
                                            <div class="col-sm-8">
                                                <input id="email" name="email" class="form-control" type="email"
                                                       style="width: 50%">
                                            </div>
                                        </div>
                                    </form>
                                    <div class="form-group">
                                        <div class="col-sm-8 col-sm-offset-3">
                                            <button class="btn btn-primary" onclick="addUser();">提交</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--add div end--%>

                </div>
                <%--start edit div--%>
                <div id="tab-3" class="tab-pane" style="display: none">
                </div>
                <%--edit div end--%>
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

<script src="${ctx}/static/js/customer/user/user.js"></script>
<script>
    $(document).ready(function () {

        //初始化ios风格按钮
        var elem = document.querySelector('.js-switch');
        var init = new Switchery(elem);

        //初始化新增页面时间框
        laydate.render({
            elem: '#birthday' //指定元素
        });

        //初始化ztree菜单
        initZtree();

        //初始化datatables
        Table.initTa();
    });

</script>
<script>
    $("#addLi").click(function(){
       // $("#addForm").form("clear")

        $(':input','#addForm')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    })
</script>
</body>
</html>
