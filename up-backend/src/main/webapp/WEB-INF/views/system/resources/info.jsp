<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>
<div>
<h4>资源信息</h4>
<form class="form-inline" id="addForm" action="#">
    <input type="hidden" name="id" id="systemResource_id" value="${systemResource.id}">
    <div class="form-group">
        <label class="col-sm-4 control-label" style="margin-bottom:10px">角色名称：</label>
        <div class="col-sm-8">
            <input id="name" name="name" class="form-control" type="text" value="${systemResource.name}">
            <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
        </div>
    </div>
    <div class="form-group" style="margin-bottom:10px">
        <label class="col-sm-4 control-label">角色标识：</label>
        <div class="col-sm-8">
            <input id="identity" name="identity" class="form-control"
                   type="text"
                   aria-required="true" aria-invalid="false" class="valid" value="${systemResource.identity}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label"> 是否显示：</label>
        <input type="checkbox" class="js-switch" checked/>
    </div>
<br>
    <div class="form-group" style="margin-bottom:10px">
        <label class="col-sm-4 control-label" >URL：</label>
        <div class="col-sm-8">
            <input id="url" name="url" class="form-control"
                   type="text"
                   aria-required="true" aria-invalid="false" class="valid" value="${systemResource.url}">
        </div>
    </div>




</form>
</div>
<script>
    $(function(){
        alert(111)
        //初始化ios风格按钮
        var elem = document.querySelector('.js-switch');
        var init = new Switchery(elem);
    });
</script>

