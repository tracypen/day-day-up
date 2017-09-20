


var resources_id;

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
        "success" :function(nodes){
            console.log(setting);
            zTreeObj = $.fn.zTree.init($("#ztree"), setting, nodes);
        },
        "error":function(msg){
            // alert(msg);
        }
    });

    //单击事件
    function zTreeOnClick(event, treeId, treeNode) {
        resources_id = treeNode.id;

        var show_oper_btn = false;
        if (treeNode.id != undefined) {
            if (treeNode.children != null) {
                show_oper_btn = false;
            } else {
                //判断是否为叶子节点
                show_oper_btn = true;
            }
        }
    //alert(show_oper_btn);
        var  url = '/system/resource/'+treeNode.id +'?show_oper_btn='+show_oper_btn;
        getPage(url);
    };
}


//分配权限
function  operPerm(){
   // Console.log(show_oper_btn)
    if (show_oper_btn == 'true'){
       // console.log("permissionId : "+resources_id);
        var url =  '/system/resource/'+ resources_id + '?allPermission=true';
        getPage(url);
    }
}
function getPage(url) {
    $.ajax({
        async:true,
        "type":"get",
        "url": ctx + url,
        data:"",
        dataType:"html",
        contentType:"json",
        success:function(html){
            if(url.indexOf('allPermission')>=0){

                $("#tBodyDiv").html(html);

            }else{

                $("#rightDiv").html(html);
            }
        },
        error:function(){
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        }
    });
}



//全选
function checkAllPerm (){
    console.log('ckecked : '+document.getElementById("checkAll").checked);
    if(document.getElementById("checkAll").checked){
        $('input[name="myCheck"]').attr("checked","checked");
    }else{

        $('input[name="myCheck"]').removeAttr("checked");
    }
}


//保存资源信息
function saveOk () {
    var permissions ;
    var str = "";
    var list = document.getElementsByName("myCheck");
    for (var i = 0; i < list.length; i++) {
        if (list[i].checked == true) {
            str += list[i].value + ",";
        }
    }
    permissions=str.substring(0,str.length-1);
    $("#permissions").val(permissions);

    $("#is_show_switch").val(document.getElementById("is_show_switch").checked);

    $.ajax({
        cache: true,
        type: "POST",
        url: ctx + '/system/resource/'+resources_id+'/update',
        data:$('#myForm').serialize(),// 你的formid
        async: false,
        error: function(e) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
        },
        success: function(data) {
            console.log(data);
            if (data){
                swal("保存成功！", "", "success");

            }else{
                swal("操作失败！", "请稍后尝试！", "error");
            }
            //更新树
            var treeObj = $.fn.zTree.getZTreeObj("ztree");
            var node = treeObj.getNodeByParam("id", resources_id, null);
            node.name = $('#name').val();
            treeObj.updateNode(node);
        }
    });

}