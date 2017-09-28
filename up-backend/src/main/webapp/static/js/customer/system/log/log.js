
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
                url: ctx + "/system/log/" + id + "/delete",
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




var Table = function() {
    var initTable = function() {

        var oTable = $('#list').dataTable({
            "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
            "bServerSide" : true, //是否启动服务器端数据导入
            "bStateSave" : true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
            "bJQueryUI" : true, //是否使用 jQury的UI theme
            "bLengthChange":true,
            "aLengthMenu" : [10, 15, 20], //更改显示记录数选项
            bLengthChange:false,
            "iDisplayLength" :15, //默认显示的记录数
            "bDeferRender": true,
            "bAutoWidth" : false, //是否自适应宽度
            "bScrollInfinite" : true, //是否启动初始化滚动条
            "bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
            "bPaginate" : true, //是否显示（应用）分页器
            "bInfo" : true, //是否显示页脚信息，DataTables插件左下角显示记录数
            "sPaginationType" : "full_numbers", //详细分页组，可以支持直接跳转到某页
            "bSort" : false, //是否启动各个字段的排序功能
            "aaSorting" : [[4, "asc"]], //默认的排序方式，第2列，升序排列
            "bFilter" : false, //是否启动过滤、搜索功能
            "aoColumns" : [{
                "mDataProp" : "id",
                "sDefaultContent" : "", //此列默认值为""，以防数据中没有此值，DataTables加载数据的时候报错
                "bVisible" : false //此列不显示
            }, {
                "mDataProp" : "id",
                "sTitle" : "排序号",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "username",
                "sTitle" : "用户",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "module",
                "sTitle" : "模块",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "description",
                "sTitle" : "操作描述",
                "sDefaultContent" : "",
                "sClass" : "center"
            },{
                "mDataProp" : "content",
                "sTitle" : "内容",
                "sDefaultContent" : "",
                "sClass" : "center",
                "width" : "30%"
            },{
                "mDataProp" : "ip",
                "sTitle" : "IP地址",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "createDate",
                "sTitle" : "操作时间",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "active",
                "sTitle" : "操作",
                "sDefaultContent" : "",
                "sClass" : "center"
            }],
            "oLanguage": { //国际化配置
                "sProcessing" : "正在获取数据，请稍后...",
                "sLengthMenu" : "每页显示 _MENU_ 条",
                "sZeroRecords" : "没有您要搜索的内容",
                "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                "sInfoEmpty" : "记录数为0",
                "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                "sInfoPostFix" : "",
                "sSearch" : "搜索",
                "sUrl" : "",
                "oPaginate": {
                    "sFirst" : "首页",
                    "sPrevious" : "上一页",
                    "sNext" : "下一页",
                    "sLast" : "末页"
                }
            },

            "fnRowCallback" : function(nRow, aData, iDisplayIndex) {

                $('td:eq(0)', nRow).html(iDisplayIndex + 1);

             //    if (aData.gender == 1) {
             //        $('td:eq(3)', nRow).html('男');
             //    }else {
             //        $('td:eq(3)', nRow).html('女');
             //    }
             //
             //    var da =new Date(aData.birthday);
             //    $('td:eq(6)', nRow).html(da.getFullYear() +'-'+ da.getMonth() +'-'+ da.getDate());
             //
             //    if (aData.active == 'TRUE') {
             //        $('td:eq(7)', nRow).html('激活');
             //    }
             //    if (aData.active == 'FALSE') {
             //        $('td:eq(7)', nRow).html('锁定');

                var da =new Date(aData.createDate);
                $('td:eq(6)', nRow).html(da.getFullYear() +'-'+ da.getMonth() +'-'+ da.getDate() +' '+ da.getHours()+':'+da.getMinutes()+':'+da.getSeconds() );
             //    }
                // if(perUpdate){
                    $('td:eq(7)', nRow).html('<a title="编辑" href="javascript:void(0);" onclick="editPage('+aData.id+')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>');

               // }else {
                    $('td:eq(7)', nRow).append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a title="删除" href="javascript:void(0);" onclick="delUser('+aData.id+')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>');
             //   }

                return nRow;
            },

            "sAjaxSource" : ctx + "/system/log/list?now=" + new Date().getTime(),
            //服务器端，数据回调处理
            "fnServerData" : function(sSource, aDataSet, fnCallback) {
              //  alert("&"+$("#searchForm").serialize());
              sSource=sSource+"&"+$("#searchForm").serialize();
                $.ajax({
                    "dataType" : 'json',
                    "type" : "get",
                    "url" : sSource,
                    "data" : aDataSet,
                    "success" : fnCallback
                });
            }
        });

        $("#docrevisontable tbody").click(function(event) { //当点击表格内某一条记录的时候，会将此记录的cId和cName写入到隐藏域中
            $(docrTable.fnSettings().aoData).each(function() {
                $(this.nTr).removeClass('row_selected');
            });
            $(event.target.parentNode).addClass('row_selected');
            var aData = docrTable.fnGetData(event.target.parentNode);

            $("#userId").val(aData.USERID);
            $("#userN").val(aData.USERNAME);
        });

        $('#search-btn').click(function() {
            //$("#errormsg").html('');
          //  $("#errordiv").hide();
            oTable.fnDraw();
        });

    }


    return {
        initTa : function() {

            if ($('#list').hasClass('dataTable')) {
                initTable = $('#list').dataTable();
                initTable.fnClearTable(); //清空一下table
                initTable.fnDestroy(); //还原初始化了的datatable
            }
            initTable();
        }
    };
}();




