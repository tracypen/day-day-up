$(function () {

    var treetable = $('#treetable').BootstrapTreeTable({
        levelSpacing: 20,//级次间距 px
        column: 0,//指定排序列号
        expandlevel: 1,//默认展开级次
        expandAll: false,//是否全部展开
        collapseAll: false,//是否全部关闭
//        expendedIcon: '<span class="glyphicon glyphicon-menu-down"></span>',//非叶子节点展开图标
//        collapsedIcon: '<span class="glyphicon glyphicon-menu-right"></span>',//非叶子节点关闭图标
        maxResult: ''//搜索最大结果集，超过将停止返回结果
    }).on("initialized.bs.treetable", function () {
        console.log('初始化完成！！！！');
        var count = treetable.BootstrapTreeTable('getMaxLevel');
        createExpandButton(count - 1);
        doDelete();
        doedit();
    });

    function createExpandButton(count) {
        for (var i = 1; i <= count; i++) {
            var $btn = $('<li><a href="#" class="expendlevel" data-level="' + i + '">' + i + '</a></li>');
            $('.pagination').append($btn).append('&nbsp;&nbsp;&nbsp;&nbsp;');
        }
        $('.expendlevel').click(function (e) {
            e.preventDefault();
            var level = $(this).data('level');
            $('#treetable').BootstrapTreeTable('expendLevel', level);
        })
    }


    /**
     show.bs.treetable 展开节点时触发事件 Event e,Object node
     shown.bs.treetable 展开节点后触发事件 Event e,Object node
     hide.bs.treetable 关闭节点时触发事件 Event e,Object node
     hidden.bs.treetable 关闭节点后触发事件 Event e,Object node
     initialized.bs.treetable 初始化插件完成后触发事件 Event e
     **/

    treetable.BootstrapTreeTable().on("show.bs.treetable", function (e, node) {
        //展开节点时触发事件
        //console.log('show', node);
    });
    treetable.BootstrapTreeTable().on("shown.bs.treetable", function (e, node) {
        // 展开节点后触发事件
        //console.log('shown', node);

    });
    treetable.BootstrapTreeTable().on("hide.bs.treetable", function (e, node) {
        // 关闭节点时触发事件
        //console.log('hide', node);
    });
    treetable.BootstrapTreeTable().on("hidden.bs.treetable", function (e, node) {
        //关闭节点后触发事件
        //console.log('hidden', node);
    });


    //根据名称查询，并高亮显示
    $('#serach').click(function () {
        var value = $('#serachvalue').val();
        var result = $('#treetable').BootstrapTreeTable('searchNodeName', value);
        $(this).text('查询(' + result + ')');
    });

    $('#expendAll').click(function () {
        $('#treetable').BootstrapTreeTable('expendAll');
    })

    $('#collapseAll').click(function () {
        $('#treetable').BootstrapTreeTable('collapseAll');
    });

    $('#reset').click(function () {
        $('#treetable').BootstrapTreeTable('reset');
        doDelete();
        doedit();
    });

    $('#destroy').click(function () {
        $('#treetable').BootstrapTreeTable('destroy');
    });




    function doDelete() {
        $('.dodel').on('click', function (e) {
            e.preventDefault();
            var node = $(this).parents('tr');
            //判断是否为叶子节点
            if (node.data('leaf') === 0) {
                swal("请先删除子节点！", "warning！", "warning");
                return false;
            }
            var dis_code = $(this).parents('tr').attr('data-id');
            console.log('node: ' + $(this).parents('tr').attr('data-id'));

            swal({
                title: "您确定要删除这条记录吗",
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
                        url: ctx + "/org_structure/district/" + dis_code + "/delete",
                        type: 'post',
                        data: dis_code,
                        dataType: 'json',
                        async: true,
                        success: function (msg) {
                            if (msg.code == 10001) {
                                swal("删除成功！", "您已经永久删除了这条信息。", "success");
                                $('#treetable').BootstrapTreeTable('removeByNode', node).val();
                            } else {
                                swal("删除失败！", "请稍后尝试！", "error");
                            }
                        }
                    });

                } else {
                    swal("已取消", "您取消了删除操作！", "error");
                }
            })


        })
    }

    function doedit(){
        $(".doedit").on('click',function () {
            var node = $(this).parents('tr');
            var dis_code = $(this).parents('tr').attr('data-id');
            console.log(dis_code);
            $.ajax({
                url: ctx + '/org_structure/district',
                type:get,
                data:'',
                async: true,
                dataType:html,
                success:function (data) {
                    $('. modal-body').html(data);
                    $("#loginModal").modal('show');
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    // 状态码
                    console.log(XMLHttpRequest.status);
                    // 状态
                    console.log(XMLHttpRequest.readyState);
                    // 错误信息
                    console.log(textStatus);
                }
            })
        })
    }






});