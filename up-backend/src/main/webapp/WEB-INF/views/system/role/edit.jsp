<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>

<div class="tab-pane">
    <div class="">
        <div class="ibox float-e-margins">

            <div class="ibox-content">
                <form id="roleForm" class="form-horizontal m-t" method="post"  action="${ctx}/system/role/saveOrUpdate">
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
                </form>
            </div>
        </div>
    </div>
</div>
<link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script src="${ctx}/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/static/js/demo/form-validate-demo.min.js"></script>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script> var result = '${result}';</script>

<script>
    $().ready(function() {
        $("#roleForm").validate({
            submitHandler:function(form){
                swal({
                    title: "您确定要提交该操作吗",
                    text: "",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "是的，现在提交！",
                    cancelButtonText: "让我再考虑一下…",
                    closeOnConfirm: false,
                    closeOnCancel: false
                }, function (isConfirm) {
                    if (isConfirm) {
                        form.submit();
                    } else {
                        swal("已取消", "您取消了提交操作！", "error");
                    }
                })
            }
        });
    });

    if (null != result && result != undefined && result != ""){
        if(result > 0){

            swal({
                title: "操作成功！",
                text: "",
                type: "success",
                showCancelButton: false,
                confirmButtonColor: "#0AA",
                confirmButtonText: "确定",
                cancelButtonText: "让我再考虑一下…",
                closeOnConfirm: false,
                closeOnCancel: false
            }, function (isConfirm) {
                if (isConfirm) {
                    window.location.href = ctx + '/system/role'
                }
            })
        }else{
            swal("操作失败！", "请稍后尝试！", "error");
        }

    }


</script>