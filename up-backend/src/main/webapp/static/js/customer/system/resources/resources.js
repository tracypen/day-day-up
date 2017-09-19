
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
        "url" : ctx + '/system/resource/ajax',
        "data" :  "",
        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType:"application/json",
        "success" :function(msg){
            nodes =  msg;
            zTreeObj = $.fn.zTree.init($("#ztree"), setting, nodes);
        },
        "error":function(msg){
            // alert(msg);
        }
    });

    //单击事件
    function zTreeOnClick(event, treeId, treeNode) {

      //  alert("id: "+ treeNode.id + ", name:  " + treeNode.name +", pid :"+treeNode.pId);
       // alert(ctx + '/system/resource/'+treeNode.pId);
        $.ajax({
            async:true,
            "type" : "get",
            "url" : ctx + '/system/resource/'+treeNode.pId,
            "data" :  "",
            dataType:'html',    //返回的数据格式：json/xml/html/script/jsonp/text
            contentType:"json",
            success :function(msg){
                $("#rightDiv").html(msg);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    };
}