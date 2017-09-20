<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>
<script>var show_oper_btn = '${show_oper_btn}';</script>
    <%--上方表单--%>
<div>
<h4>资源信息</h4>
<form class="form-inline" id="myForm" action="#">
    <input type="hidden" id="permissions" name="permissions">
    <input type="hidden" id="id" name="${systemResource.id}">
    <div class="form-group">
        <label class="col-sm-4 control-label" style="margin-bottom:10px">资源名称：</label>
        <div class="col-sm-8">
            <input id="name" name="name" class="form-control" type="text" value="${systemResource.name}">
            <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
        </div>
    </div>
    <div class="form-group" style="margin-bottom:10px">
        <label class="col-sm-4 control-label">资源标识：</label>
        <div class="col-sm-8">
            <input id="identity" name="identity" class="form-control"
                   type="text"
                   aria-required="true" aria-invalid="false" class="valid" value="${systemResource.identity}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label"> 显示：</label>
        <input name="show" type="checkbox" id="is_show_switch"  <c:if test="${systemResource.show == true}">checked</c:if> class="js-switch" />
    </div>
<br>
    <div class="form-group" style="margin-bottom:10px">
        <label class="col-sm-4 control-label" >&nbsp; &nbsp;&nbsp;URL：</label>
        <div class="col-sm-8">
            <input id="url" name="url" class="form-control"
                   type="text"
                   aria-required="true" aria-invalid="false" class="valid" value="${systemResource.url}">
        </div>
    </div>
</form>
</div>
<br>
<br>
<br>
<br>
    <%--下方表格--%>
<div>
    <a onclick="operPerm();" class="btn btn-primary" href="javascript:void(0);"
            <c:if test="${show_oper_btn == false}">disabled="disabled" </c:if>
       id="operater_permission">分配权限</a>

    <a onclick="saveOk();" class="btn btn-info" href="javascript:void(0);" style="margin-left: 90px">保存</a>
<br><br>
    <table class="table table-striped table-bordered table-hover dataTables-example" id="tBodyDiv">
        <thead>
        <tr>
            <th>权限编号</th>
            <th>权限名称</th>
            <th>权限标识</th>
            <th>描述</th>
            <th>是否显示</th>
        </tr>
        </thead>
        <tbody >
      <c:if test="${not empty systemResource.permissionList}">
          <c:forEach var="permissionItem" items="${systemResource.permissionList}" varStatus="var">
              <tr>
                  <th>${var.index + 1}</th>
                  <th>${permissionItem.name}</th>
                  <th>${permissionItem.permission}</th>
                  <th>${permissionItem.description}</th>
                  <th>${permissionItem.show == true ? '显示' : '隐藏'}</th>

              </tr>
          </c:forEach>


      </c:if>

        </tbody>

    </table>

</div>
<script>
    $(function(){
      //  console.log(${show_oper_btn});
        //初始化ios风格按钮
        var elem = document.querySelector('.js-switch');
        var init = new Switchery(elem);
    });
</script>
