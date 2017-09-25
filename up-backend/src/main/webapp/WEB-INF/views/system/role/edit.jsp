<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>

<div class="tab-pane">
    <div class="">
        <div class="ibox float-e-margins">

            <div class="ibox-content">
                <form id="roleForm" class="form-horizontal m-t" method="post" action="${ctx}/system/role/saveOrUpdate">
                    <input  name="id" value="${role.id}" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">角色名称：</label>
                        <div class="col-sm-8">
                            <input id="name"  name="name" class="form-control required" type="text" value="${role.name}"
                                   style="width: 50%" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">角色标识：</label>
                        <div class="col-sm-8">
                            <input  name="role" class="form-control" type="text" value="${role.role}"
                                   aria-required="true" aria-invalid="false" class="valid"
                                   style="width: 50%" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">角色描述：</label>
                        <div class="col-sm-8">
                            <input  name="description" class="form-control" type="text" value="${role.description}"
                                   aria-required="true" aria-invalid="false" class="valid"
                                   style="width: 50%" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">角色类型：</label>
                        <div class="col-sm-8">
                            <input  name="typeName" class="form-control" type="text" value="${role.typeName}"
                                   aria-required="true" aria-invalid="false" class="valid"
                                   style="width: 50%" required>
                        </div>
                    </div>
                </form>
                <br>
                <br>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="submit" value="提交" class="btn btn-primary" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <a  href="${ctx}/system/role" class="btn btn-primary">返回</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/static/js/demo/form-validate-demo.min.js"></script>

<script>
    $().ready(function() {
        $("#roleForm").validate({
            submitHandler:function(form){
                alert("submitted");
                form.submit();
            }
        });
    });




</script>