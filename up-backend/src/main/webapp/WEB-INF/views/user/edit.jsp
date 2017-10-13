<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf"%>
<div class="tab-pane">
    <div class="">
        <div class="ibox float-e-margins">

            <div class="ibox-content">
                <form class="form-horizontal m-t" id="addForm" action="/">
                    <input id="up_id" name="id" value="${user.id}" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名：</label>
                        <div class="col-sm-8">
                            <input id="up_name" name="name" class="form-control" type="text" value="${user.name}"
                                   style="width: 50%">
                            <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">真实姓名：</label>
                        <div class="col-sm-8">
                            <input id="up_userRealName" name="userRealName" class="form-control" type="text" value="${user.userRealName}"
                                   aria-required="true" aria-invalid="false" class="valid"
                                   style="width: 50%">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">性别：${user.gender}</label>


                        <div class="col-sm-8" id="up_gender">
                            <div class="radio radio-info radio-inline">
                                <input type="radio" id="inlineRadio1" value="1" name="up_gender"  <c:if test="${user.gender eq 1}">checked</c:if> >
                                <label for="inlineRadio1"> 男 </label>
                            </div>
                            <div class="radio radio-inline">
                                <input type="radio" id="inlineRadio2" value="2" name="up_gender" <c:if test="${user.gender eq 2}">checked</c:if> >
                                <label for="inlineRadio2"> 女 </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">QQ：</label>
                        <div class="col-sm-8">
                            <input id="up_qq" name="userRealName" class="form-control" type="text" value="${user.userRealName}"
                                   aria-required="true" aria-invalid="false" class="valid"
                                   style="width: 50%">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">手机号：</label>
                        <div class="col-sm-8">
                            <input id="up_phone" name="phone" class="form-control" type="text" value="${user.phone}"
                                   aria-required="true" aria-invalid="false" class="valid"
                                   style="width: 50%">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">生日：</label>
                        <div class="col-sm-8">
                            <input id="up_birthday"  name="birthday" type="text"  value="<fmt:formatDate value='${user.birthday}' pattern='yyyy-MM-dd'/>"  class="form-control" style="width: 50%">

                        </div>
                    </div>

                 <%--   <div class="form-group">
                        <label class="col-sm-3 control-label">密码：</label>
                        <div class="col-sm-8">
                            <input id="password" name="password" class="form-control" type="password"
                                   style="width: 50%">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">确认密码：</label>
                        <div class="col-sm-8">
                            <input id="confirm_password" name="confirm_password" class="form-control"
                                   type="password" style="width: 50%">
                            &lt;%&ndash;<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>&ndash;%&gt;
                        </div>
                    </div>--%>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">E-mail：</label>
                        <div class="col-sm-8">
                            <input id="up_email" name="email" class="form-control" value="${user.email}" type="email" style="width: 50%">
                        </div>
                    </div>
                </form>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-primary" onclick="updatePage();">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- UY BEGIN -->
<%--<div id="uyan_frame"></div>--%>
<%--<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js?uid=2146316"></script>--%>
<!-- UY END -->
<script>
    $(document).ready(function () {
    laydate.render({
        elem: '#up_birthday' //指定元素
    });
    });
</script>