<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@include file="/WEB-INF/views/common/import-css-js.jspf" %>
  <script>var ctx = '${ctx}', uid = '${user.id}', is_logined = '${status}';</script>

</head>
<body class="fixed-sidebar full-height-layout gray-bg">
<div id="wrapper">
  <%@include file="/WEB-INF/decorators/menu.jsp" %>
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <%@include file="/WEB-INF/decorators/search.jsp" %>

    <div class="row J_mainContent" id="content-main">

      <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx}/admin/home" frameborder="0" data-id="${ctx}/admin/home" seamless></iframe>
    </div>
    <%@include file="/WEB-INF/decorators/footer.jsp" %>
  </div>
</div>
<%--<decorator:getProperty property="page.script"/>--%>
<%--<decorator:getProperty property="page.css"/>--%>
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">提示</h4>
      </div>
      <div class="modal-body">
        您已登录！
      </div>
    </div>
  </div>
</div>

<script>
    if (is_logined) {
        $("#loginModal").modal('show');
        setTimeout(function(){
            $("#loginModal").modal('hide');
        },1000)
    }

    $(".J_menuItem").click(function () {

        console.log( $(".J_iframe").attr("src"));
        console.log($(this).attr("data-url"));
        $(".J_iframe").attr("src",$(this).attr("data-url"));
    })

</script>
</body>
</html>