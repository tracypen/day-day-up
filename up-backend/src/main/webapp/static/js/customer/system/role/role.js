//*********************************************dictionary**********************************************

function deleteRole(id) {
    swal({
        title: "您确定要删除该角色吗",
        text: "删除后无法回复，请谨慎操作！！",
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
                url: ctx + "/system/role/" + id + "/delete",
                type: 'post',
                data: id,
                dataType: 'json',
                async: true,
                success: function (msg) {
                    if (msg.code == 10001) {
                        swal("删除成功！", "您已经永久删除了该条记录。", "success");
                        $("#relode_btn").click();
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

                $('td:eq(2)', nRow).html('<a href="'+ctx+'/system/role/saveOrUpdate?id='+aData.id +'" title="编辑"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>');


                $('td:eq(2)', nRow).append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a title="删除" href="javascript:void(0);" onclick="deleteRole(' + aData.id + ')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>');

                $('td:eq(2)', nRow).append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a title="授权" href="javascript:void(0);" onclick="loadPermission(' + aData.id + ')"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>');


                return nRow;
            },
            "sAjaxSource": ctx + "/system/role/all?now=" + new Date().getTime(),
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

            $("#name").val(aData.name);
             $("#role").val(aData.role);
             $("#description").val(aData.description);
             $("#typeName").val(aData.typeName);
            //查询选中字典类型对应的数据字典  右侧显示
           // Table.initTa($("#typeCode").val())


        });


        $('#relode_btn').click(function () {
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

    var roleId = "";
    function loadPermission(id){
    //获取所有资源菜单 以及资源对应的操作权限
        roleId = id;
        var zTreeObj;
        var setting = {
            check: {
                enable: true,
                chkStyle: "checkbox"
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
               // onCheck: onCheck,
                onClick: zTreeOnClick
            }
        };


        //选中事件
        function onCheck(event, treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.expandNode(treeNode, null, null, null, true);
        }

        var nodes ;
        $.ajax({
            async:true,
            "type" : "get",
            "url" : ctx + '/system/role/'+id+'/permission',
            "data" :  "",
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            contentType:"application/json",
            "success" :function(result){


                $("#name").val(result.role.name);
                $("#role").val(result.role.role);
                $("#description").val(result.role.description);
                $("#typeName").val(result.role.typeName);

                $("#save_btn").show();
                nodes = result.treeList;
                zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, nodes);
            },
            "error":function(msg){
                alert(msg);
            }
        });

        //单击事件
        function zTreeOnClick(event, treeId, treeNode) {
            //alert(treeId);
            alert("id: "+ treeNode.id + ", name:  " + treeNode.name +", pid :"+treeNode.pId);
            //$(treeNode).addClass('active');
        };
    }

var resourceId="";
//保存权限
$("#save_btn").click(function (){
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var str="";
    var nodes=treeObj.getCheckedNodes(true);
    for(var i=0;i<nodes.length;i++){
        //获取选中节点的值
        str+=nodes[i].id+",";
    }
    resourceId=str.substring(0,str.length-1);
    console.log(resourceId);
    $.ajax({
        type:"POST",
        data:"roleId="+roleId+"&resourceId="+resourceId,
        dataType: 'json',
        url:ctx+"/system/role/updatRoleResourPermission",
        success:function(result){
            if (result.code == 10001) {
                swal("保存成功！", "", "success");
                $("#relode_btn").click();
            } else {
                swal("保存失败！", "请稍后尝试！", "error");
            }
        },
        error:function(){
            swal("保存失败！", "请稍后尝试！", "error");
        }
    });
});