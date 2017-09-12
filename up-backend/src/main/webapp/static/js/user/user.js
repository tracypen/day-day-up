$(function () {


});

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
                    alert(123);
                    window.location.href = ctx+'/user/list';
                    swal({title: "操作成功", text: "数据已经删除", type: "success"});
                }
            });
            swal("删除成功！", "您已经永久删除了这条信息。", "success")
           // window.location.href = ctx + '/user/list'
        } else {
            swal("已取消", "您取消了删除操作！", "error")
        }
    })



}