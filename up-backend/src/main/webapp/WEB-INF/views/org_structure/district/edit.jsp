<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<div class="tab-pane">
    <div class="ibox float-e-margins">

        <div class="ibox-content">
            <form class="form-horizontal m-t" id="districtForm" action="">
                <input id="id" name="id" value="${district.id}" type="hidden">
                <input id="parentCode" name="parentCode" value="${district.parentCode}" type="hidden">
                <input id="level" name="level" value="${disLevel}" type="hidden">
                <c:if test="${doUpdate}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">编码：</label>
                        <div class="col-sm-8">
                            <input id="code" name="code" class="form-control" type="text" value="${district.code}"
                                   readonly style="width: 50%">
                                <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                        </div>
                    </div>
                </c:if>
                <div class="form-group">
                    <label class="col-sm-3 control-label">名称：</label>
                    <div class="col-sm-8">
                        <input id="name" name="name" class="form-control" type="text" value="${district.name}"
                               aria-required="true" aria-invalid="false" class="valid"
                               style="width: 50%" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-warning" onclick="cancel();">取消</button>&nbsp;&nbsp;&nbsp;
                        <input type="submit" class="btn btn-primary" value="提交" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script src="${ctx}/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/static/js/demo/form-validate-demo.min.js"></script>
<script>
    $(document).ready(function () {

        $("#districtForm").validate({
            onfocusout: function (element) {
                $(element).valid();
            },
            submitHandler: function (form) {
                addOrUpdate();
            }
        });

    });

    function cancel() {
        $("#loginModal").modal('hide');
    }

    function addOrUpdate() {
        $.ajax({
            url: ctx + '/org_structure/district/update',
            type: 'post',
            data: $("#districtForm").serialize(),
            async: true,
            dataType: 'json',
            success: function (msg) {
                $("#loginModal").modal('hide');
                if (msg.code == 10001) {
                    swal("操作成功！", "", "success");
                } else if (msg.code == 10003) {
                    swal("新增失败！", "请稍后尝试！", "error");
                } else if (msg.code == 10004) {
                    swal("修改失败！", "请稍后尝试！", "error");
                }
            },
            error: function (XMLHttpRequest, textStatus) {
                $("#loginModal").modal('hide');
                swal("操作失败！", "请稍后尝试！", "error");
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
            }
        })
    }


</script>