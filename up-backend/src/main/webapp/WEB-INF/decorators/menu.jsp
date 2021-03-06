<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<link rel="stylesheet" href="${ctx}/static/css/fileinput/file-input.min.css">
<link rel="stylesheet" href="${ctx}/static/css/jcrop/jquery.Jcrop.min.css">
<link rel="stylesheet" href="${ctx}/static/css/sco/scojs.css">
<link rel="stylesheet" href="${ctx}/static/css/sco/sco.message.css">

<style>
    .dropdown img {
        width: 64px;
        height: 64px
    }
</style>
<!--左侧导航-->
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="" id="headImg"/></span>
                    <%--<span><img alt="image" class="img-circle" src="${user.name}"/></span>--%>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">
                                 <shiro:principal type="com.hp.up.core.web.shiro.UserShiro" defaultValue="Mcgrady" property="name"></shiro:principal></strong></span>
                                <span class="text-muted text-xs block">管理员<b class="caret"></b></span>
                                </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="J_menuItem" id="edit_image" href="javascript:void(0);">修改头像</a>
                        </li>
                        <li><a class="J_menuItem" href="profile.html">个人资料</a>
                        </li>
                        <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                        </li>
                        <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${ctx}/logout.action">安全退出</a>
                        </li>
                    </ul>
                </div>
                <div class="logo-element">H+
                </div>
            </li>


            <li>
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">系统管理</span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level" >
                    <li>
                        <a class="J_menuItem" data-url="${ctx}/user">用户管理</a>
                    </li>
                    <li>
                        <a class="J_menuItem" data-url="${ctx}/system/role">角色管理</a>
                    </li>

                    <li>
                        <a class="J_menuItem" data-url="${ctx}/system/resource">资源管理</a>
                    </li>

                    <li>
                        <a class="J_menuItem" data-url="${ctx}/system/dictionaryType">数据字典</a>
                    </li>


                </ul>

            </li>

            <%-- <li>
                 <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span
                         class="fa arrow"></span></a>
                 <ul class="nav nav-second-level">
                     <li><a class="J_menuItem" href="form_basic.html">基本表单</a>
                     </li>
                     <li><a class="J_menuItem" href="form_validate.html">表单验证</a>
                     </li>
                     <li><a class="J_menuItem" href="form_advanced.html">高级插件</a>
                     </li>
                     <li><a class="J_menuItem" href="form_wizard.html">表单向导</a>
                     </li>
                     <li>
                         <a href="#">文件上传 <span class="fa arrow"></span></a>
                         <ul class="nav nav-third-level">
                             <li><a class="J_menuItem" href="form_webuploader.html">百度WebUploader</a>
                             </li>
                             <li><a class="J_menuItem" href="form_file_upload.html">DropzoneJS</a>
                             </li>
                             <li><a class="J_menuItem" href="form_avatar.html">头像裁剪上传</a>
                             </li>
                         </ul>
                     </li>
                     <li>
                         <a href="#">编辑器 <span class="fa arrow"></span></a>
                         <ul class="nav nav-third-level">
                             <li><a class="J_menuItem" href="form_editors.html">富文本编辑器</a>
                             </li>
                             <li><a class="J_menuItem" href="form_simditor.html">simditor</a>
                             </li>
                             <li><a class="J_menuItem" href="form_markdown.html">MarkDown编辑器</a>
                             </li>
                             <li><a class="J_menuItem" href="code_editor.html">代码编辑器</a>
                             </li>
                         </ul>
                     </li>
                     <li><a class="J_menuItem" href="suggest.html">搜索自动补全</a>
                     </li>
                     <li><a class="J_menuItem" href="layerdate.html">日期选择器layerDate</a>
                     </li>
                 </ul>
             </li>--%>


            <li>
                <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">组织架构</span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a class="J_menuItem" data-url="${ctx}/org_structure/district">区域管理</a></li>
                    <li><a class="J_menuItem" data-url="${ctx}/system/log">机构管理</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">系统监控 </span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a class="J_menuItem" data-url="${ctx}/admin/database/monitor">数据监控</a></li>
                    <li><a class="J_menuItem" data-url="${ctx}/system/log">系统日志</a></li>
                </ul>
            </li>

        </ul>
    </div>
</nav>

<!--图片裁剪插件-->
<script type="text/javascript" src="${ctx}/static/js/plugins/fileupload/jcrop/jquery.Jcrop.min.js"></script>
<!--文件上传插件-->
<script type="text/javascript" src="${ctx}/static/js/plugins/fileupload/fileinput/file-input.min.js"></script>
<!--fileinput中文化-->
<script type="text/javascript" src="${ctx}/static/js/plugins/fileupload/fileinput/zh.js"></script>
<!--模态窗口优化插件,sco还有很多其他优化组件-->
<script type="text/javascript" src="${ctx}/static/js/plugins/fileupload/sco/sco.modal.js"></script>
<!--腾讯的模板插件,使用起来类似JSTL和EL表达式-->
<script type="text/javascript" src="${ctx}/static/js/plugins/fileupload/template/template.js"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/fileupload/portrait.js"></script>
<!--这段不是js代码,注意了,这个是ArtTemplate专用的模板代码,就是前面加载的template.js这个插件-->
<script id="portraitUpload" type="text/html">
    <div style="padding: 10px 20px">
        <form role="form" enctype="multipart/form-data" method="post">
            <div class="embed-responsive embed-responsive-16by9">
                <div class="embed-responsive-item pre-scrollable">
                    <img alt="" src="${ctx}/static/images/showings.jpg" id="cut-img"
                         class="img-responsive img-thumbnail"/>
                </div>
            </div>
            <div class="white-divider-md"></div>
            <input type="file" name="imgFile" id="fileUpload"/>
            <div class="white-divider-md"></div>
            <div id="alert" class="alert alert-danger hidden" role="alert"></div>
            <input type="hidden" id="x" name="x"/>
            <input type="hidden" id="y" name="y"/>
            <input type="hidden" id="w" name="w"/>
            <input type="hidden" id="h" name="h"/>
        </form>
    </div>
</script>

<script>
    $.ajax({
        async:true,
        "type" : "get",
        "url" : ctx + '/file/headImg',
        "data" :  "",
        dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType:"application/json",
        "success" :function(msg){
            $("#headImg").attr("src", msg);
        },
        error:function(){
          //  swal("添加用户失败！", "请稍后尝试！", "error");

        }
    });

</script>


