# up-parent
 父级项目 聚合

111111 salt 123456
81255cb0dca1a5f304328a70ac85dcbd

datatables url
http://localhost:8080/dictionaryType/dictionary/1001/list?now=1505466957845&&sEcho=2&iColumns=6&sColumns=%2C%2C%2C%2C%2C&iDisplayStart=0&iDisplayLength=15&mDataProp_0=id&bSortable_0=true&mDataProp_1=name&bSortable_1=true&mDataProp_2=name&bSortable_2=true&mDataProp_3=code&bSortable_3=true&mDataProp_4=id&bSortable_4=true&mDataProp_5=id&bSortable_5=true&iSortCol_0=4&sSortDir_0=asc&iSortingCols=1


iSortCol_0=1&sSortDir_0=asc

DataProp_0=id



1.引入ios风格按钮
<link href="${ctx}/static/css/plugins/switchery/switchery.css" rel="stylesheet">
<script src="${ctx}/static/js/plugins/switchery/switchery.js"></script>
 //初始化ios风格按钮
        var elem = document.querySelector('.js-switch');
        var init = new Swit chery(elem);

2.引入弹窗插件
<link href="${ctx}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script src="${ctx}/static/js/plugins/sweetalert/sweetalert.min.js"></script>

 function delUser(id) {
     swal({
         title: "您确定要删除这条信息吗",
         text: "删除后将无法恢复，请谨慎操作！",
         type: "warning",
         showCancelButton: true,
         confirmButtonColor: "#DD6B55",
         confirmButtonText: "是的，我要删除！",
         cancelButtonText: "让我再考虑一下…",
         closeOnConfirm: false,
         closeOnCancel: false
     }, function (isConfirm) {
         if (isConfirm) {
             $.ajax({
                 url: ctx + "/user/" + id + "/delete",
                 type:'post',
                 data: id,
                 dataType: 'json',
                 async: true,
                 success: function (msg) {
                    // swal({title: "操作成功", text: "数据已经删除", type: "success"});
                     //window.location.href = ctx+'/user/list';
                     if (msg.code == 10001){
                         swal("删除成功！", "您已经永久删除了这条信息。", "success");
                         $("#search-btn").click();
                     }else{
                         swal("删除失败！", "请稍后尝试！", "error");
                     }
                 }
             });
 
         } else {
             swal("已取消", "您取消了删除操作！", "error");
         }
     })
 
 }
 
 
 
 听音乐
 http://www.sojson.com/other/music.html
 天气
 http://www.sojson.com/blog/234.html