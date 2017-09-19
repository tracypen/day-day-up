//*********************************************dictionary**********************************************

function del_dic_type(id) {
    swal({
        title: "您确定要删除该类型吗",
        text: "删除后将会删除该类型下所有数据字典！！",
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
                url: ctx + "/dictionaryType/" + id + "/delete",
                type: 'post',
                data: id,
                dataType: 'json',
                async: true,
                success: function (msg) {
                    // swal({title: "操作成功", text: "数据已经删除", type: "success"});
                    //window.location.href = ctx+'/user/list';
                    if (msg.code == 10001) {
                        swal("删除成功！", "您已经永久删除了这字典类型。", "success");
                        $("#search-type-btn").click();
                    } else {
                        swal("删除失败！", "请稍后尝试！", "error");
                    }
                }
            });

        } else {
            swal("已取消", "您取消了删除操作！", "error");
        }
    })

}



var roleTable = function () {
    var initTables = function () {

        var oTable = $('#role-list').dataTable({
            "bProcessing": true, //DataTables载入数据时，是否显示‘进度’提示
            "bServerSide": true, //是否启动服务器端数据导入
            "bStateSave": true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
            "bJQueryUI": true, //是否使用 jQury的UI theme
            "bLengthChange": true,
            // "sScrollY" : 450, //DataTables的高
            //  "sScrollX" : 820, //DataTables的宽
            "aLengthMenu": [10, 15, 20], //更改显示记录数选项
            bLengthChange: false,
            "iDisplayLength": 15, //默认显示的记录数
            "bDeferRender": true,
            "bAutoWidth": false, //是否自适应宽度
            "bScrollInfinite": false, //是否启动初始化滚动条
            "bScrollCollapse": false, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
            "bPaginate": false, //是否显示（应用）分页器
            "bInfo": false, //是否显示页脚信息，DataTables插件左下角显示记录数
            "sPaginationType": "full_numbers", //详细分页组，可以支持直接跳转到某页
            "bSort": false, //是否启动各个字段的排序功能
            "aaSorting": [[1, "asc"]], //默认的排序方式，第2列，升序排列
            "bFilter": false, //是否启动过滤、搜索功能
            "aoColumns": [{
                "mDataProp": "id",
                "sDefaultContent": "", //此列默认值为""，以防数据中没有此值，DataTables加载数据的时候报错
                "bVisible": false //此列不显示
            }, {
                "mDataProp": "name",
                "sTitle": "排序号",
                "sDefaultContent": "",
                "sClass": "center"
            }, {
                "mDataProp": "name",
                "sTitle": "角色名称",
                "sDefaultContent": "",
                "sClass": "center"
            },  {
                "mDataProp": "id",
                "sTitle": "操作",
                "sDefaultContent": "",
                "sClass": "center"
            }],

            "fnRowCallback": function (nRow, aData, iDisplayIndex) {

                $('td:eq(0)', nRow).html(iDisplayIndex + 1);



                $('td:eq(2)', nRow).html('<a title="编辑"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>');


                $('td:eq(2)', nRow).append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a title="删除" href="javascript:void(0);" onclick="del_dic_type(' + aData.id + ')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>');

                $('td:eq(2)', nRow).append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a title="授权" href="javascript:void(0);" onclick="loadMenu(' + aData.id + ')"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>');


                return nRow;
            },
            "sAjaxSource": ctx + "/role/all?now=" + new Date().getTime(),
            //服务器端，数据回调处理
            "fnServerData": function (sSource, aDataSet, fnCallback) {
               // $("#dictionaryDiv").hide();
                sSource = sSource + "&" + $("#searchForm").serialize();
                $.ajax({
                    "dataType": 'json',
                    "type": "get",
                    "url": sSource,
                    "data": aDataSet,
                    "success": fnCallback
                });
            }
        });

        //当点击表格内某一条记录的时候，获取表格数据进行进一步处理
        $("#role-list tbody").click(function (event) {
            $(oTable.fnSettings().aoData).each(function () {
                $(this.nTr).removeClass('row_selected');
            });
            $(event.target.parentNode).addClass('row_selected');
            var aData = oTable.fnGetData(event.target.parentNode);
            alert(aData.id);
          //   $("#typeCode").val(aData.id);
            // $("#userN").val(aData.USERNAME);
            //查询选中字典类型对应的数据字典  右侧显示
           // Table.initTa($("#typeCode").val())


        });

        $('#search-type-btn').click(function () {
            //$("#errormsg").html('');
            //  $("#errordiv").hide();
            oTable.fnDraw();
        });

    }


    return {
        initTa: function () {
            if ($('#role-list').hasClass('dataTable')) {
                var  initTable = $('#role-list').dataTable();
                initTable.fnClearTable(); //清空一下table
                initTable.fnDestroy(); //还原初始化了的datatable
            }
            initTables();
        }
    };
}();



/**
 * 初始化ztree菜单
 */
function initZtree() {
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        view: {
            dblClickExpand: false,
            selectedMulti: false, //设置是否能够同时选中多个节点
            showIcon: true,  //设置是否显示节点图标
            showLine: true,  //设置是否显示节点与节点之间的连线
            showTitle: true,  //设置是否显示节点的title提示信息
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
            }
        },
        callback: {
            onClick: zTreeOnClick, //单击事件
        }
    };
    var nodes ;
    $.ajax({
        async:true,
        "type" : "get",
        "url" : ctx + '/menu/ajax',
        "data" :  "",
        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType:"application/json",
        "success" :function(msg){
            nodes =  msg;
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, nodes);
        },
        "error":function(msg){
            // alert(msg);
        }
    });

    //单击事件
    function zTreeOnClick(event, treeId, treeNode) {
        //alert(treeId);
        alert("id: "+ treeNode.id + ", name:  " + treeNode.name +", pid :"+treeNode.pId);
        //$(treeNode).addClass('active');
    };
}