
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




var Table = function() {
    var initTable = function() {

        var oTable = $('#list').dataTable({
            "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
            "bServerSide" : true, //是否启动服务器端数据导入
            "bStateSave" : true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
            "bJQueryUI" : true, //是否使用 jQury的UI theme
            "bLengthChange":true,
           // "sScrollY" : 450, //DataTables的高
          //  "sScrollX" : 820, //DataTables的宽
            "aLengthMenu" : [10, 15, 20], //更改显示记录数选项
            bLengthChange:false,
            "iDisplayLength" :15, //默认显示的记录数
            "bDeferRender": true,
            "bAutoWidth" : false, //是否自适应宽度
            "bScrollInfinite" : false, //是否启动初始化滚动条
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
                "mDataProp" : "name",
                "sTitle" : "排序号",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "name",
                "sTitle" : "用户名",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "userRealName",
                "sTitle" : "姓名",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "gender",
                "sTitle" : "性别",
                "sDefaultContent" : "",
                "sClass" : "center"
            },{
                "mDataProp" : "phone",
                "sTitle" : "手机号",
                "sDefaultContent" : "",
                "sClass" : "center"
            },{
                "mDataProp" : "email",
                "sTitle" : "邮箱",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "birthday",
                "sTitle" : "生日",
                "sDefaultContent" : "",
                "sClass" : "center"
            }, {
                "mDataProp" : "active",
                "sTitle" : "状态",
                "sDefaultContent" : "",
                "sClass" : "center"
            },{
            "mDataProp" : "id",
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

                if (aData.gender == 1) {
                    $('td:eq(3)', nRow).html('男');
                }else {
                    $('td:eq(3)', nRow).html('女');
                }

                var da =new Date(aData.birthday);
                $('td:eq(6)', nRow).html(da.getFullYear() +'-'+ da.getMonth() +'-'+ da.getDate());

                if (aData.active == 'TRUE') {
                    $('td:eq(7)', nRow).html('激活');
                }
                if (aData.active == 'FALSE') {
                    $('td:eq(7)', nRow).html('锁定');
                }
                // if(perUpdate){
                    $('td:eq(8)', nRow).html('<a title="编辑" href="javascript:void(0);" onclick="editPage('+aData.id+')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>');

               // }else {
                    $('td:eq(8)', nRow).append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a title="删除" href="javascript:void(0);" onclick="delUser('+aData.id+')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>');
             //   }

                return nRow;
            },

            "sAjaxSource" : ctx + "/user/list?now=" + new Date().getTime(),
            //服务器端，数据回调处理
            "fnServerData" : function(sSource, aDataSet, fnCallback) {
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
        $('#listLi').click(function() {
            $("#editLi").removeClass('active');
            $("#optionDiv").show();
            $("#addLi").show();
            $("#editLi").hide();
            $("#tab-3").hide();



            oTable.fnDraw();
        });

    }


    return {
        initTa : function() {
            //initTable.fnClearTable();//清空数据.fnClearTable();//清空数据
            //initTable.fnDestroy(); //还原初始化了的datatable

            if ($('#list').hasClass('dataTable')) {
                initTable = $('#list').dataTable();
                initTable.fnClearTable(); //清空一下table
                initTable.fnDestroy(); //还原初始化了的datatable
            }
            initTable();
        }
    };
}();


function addUser(){
    var jsonData = {
        "name":$("#name").val(),
        "realName":$("#userRealName").val(),
        "birthday":$("#birthday").val(),
        "password":$("#password").val(),
        "email":$("#email").val(),
        "qq":$("#qq").val(),
        "gender":$("input[name='gender']:checked").val(),  //$('input:radio:checked').val()；$("input[name='up_gender']:checked").val()
        "phone":$("#phone").val()
    }
    console.log(JSON.stringify(jsonData));
   // alert($('#gender input:radio:checked').val());
    $.ajax({
        async:true,
        "type" : "post",
        "url" : ctx + '/user/add',
        "data" :  JSON.stringify(jsonData),
        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType:"application/json",
        "success" :function(msg){
            if (msg == true){
                swal("添加用户成功！", "success", "success");
                $("#search-btn").click();
            }else{
                swal("添加用户失败！", "请稍后尝试！", "error");
            }
        },
        error:function(){
            swal("添加用户失败！", "请稍后尝试！", "error");

        }
    });

}

function updatePage() {
    var jsonData = {
        "id":$("#up_id").val(),
        "name":$("#up_name").val(),
        "userRealName":$("#up_userRealName").val(),
        "gender":$("input[name='up_gender']:checked").val(),  //$('input:radio:checked').val()；
        "birthday":$("#up_birthday").val(),
        "email":$("#up_email").val(),
        "phone":$("#up_phone").val(),
        "qq":$("#up_qq").val()
    }
    console.log(JSON.stringify(jsonData));
    console.log($("input[name='up_gender']:checked").val());
    $.ajax({
        async:true,
        "type" : "post",
        "url" : ctx + '/user/update',
        "data" :  JSON.stringify(jsonData),
        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType:"application/json",
        "success" :function(msg){
            if (msg == true){
                swal("修改用户成功！", "success", "success");
                $("#search-btn").click();
            }else{
                swal("修改用户失败！", "请稍后尝试！", "error");
            }
        },
        error:function(){
            swal("修改用户失败！", "请稍后尝试！", "error");

        }
    });

}

function editPage(id) {
    $.ajax({
        async:true,
        "type" : "post",
        "url" : ctx + '/user/edit/'+id,
        dataType:'html',    //返回的数据格式：json/xml/html/script/jsonp/text
        "success" :function(msg){
            $("#tab-3").html(msg);
            $("#editLi").show();
            // $("#editLi").click();
            $("#editLi").addClass('active').siblings().removeClass('active');
            $("#optionDiv").hide();
            $("#addLi").hide();
            $("#tab-3").show();
        },
        error:function(){

        }
    });

    //初始化编辑页面时间框
    laydate.render({
        elem: '#up_birthday' //指定元素
    });
}

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
         "url" : ctx + '/role/ajax',
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

