<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>多果空答案</TITLE>

<SCRIPT type=text/javascript src="jquery-1.8.2.min.js"></SCRIPT>

<SCRIPT type=text/javascript src="FormulaEditor.js"></SCRIPT>

<SCRIPT type=text/javascript src="accessKey.js"></SCRIPT>

<SCRIPT type=text/javascript src="excanvas.js"></SCRIPT>
<LINK rel=stylesheet type=text/css href="FormulaEditor.css">
<LINK rel=stylesheet type=text/css href="FormulaEditorForAll.css">
<STYLE type=text/css>.windows-S {
	FONT-SIZE: 12px
}

.windows-S {
	POSITION: relative; PADDING-BOTTOM: 0px; MARGIN: 0px auto; PADDING-LEFT: 0px; WIDTH: 730px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
.w-S-body {
	WIDTH: 462px
}
.w-S-body H4 {
	BORDER-BOTTOM: #ff7e45 1px dotted; BORDER-LEFT: #ff7e45 1px dotted; LINE-HEIGHT: 30px; BACKGROUND-COLOR: #fffbeb; MARGIN: 0px auto 3px; PADDING-LEFT: 10px; WIDTH: 448px; HEIGHT: 30px; COLOR: #ff7e45; BORDER-TOP: #ff7e45 1px dotted; FONT-WEIGHT: normal; BORDER-RIGHT: #ff7e45 1px dotted
}
.w-S-body DL {
	BORDER-BOTTOM: #cdd5e4 1px solid; BORDER-LEFT: #cdd5e4 1px solid; BACKGROUND-COLOR: #f3f8ff; MARGIN: 0px auto 4px; WIDTH: 458px; DISPLAY: block; BORDER-TOP: #cdd5e4 1px solid; BORDER-RIGHT: #cdd5e4 1px solid
}
.w-S-body H5 {
	BORDER-BOTTOM: #cdd5e4 1px solid; BORDER-LEFT: #cdd5e4 1px solid; BACKGROUND-COLOR: #f3f8ff; MARGIN: 0px auto 4px; WIDTH: 458px; DISPLAY: block; BORDER-TOP: #cdd5e4 1px solid; BORDER-RIGHT: #cdd5e4 1px solid
}
.w-S-body DL DD {
	BORDER-BOTTOM: #cdd5e4 1px dotted; PADDING-BOTTOM: 6px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; DISPLAY: block; PADDING-TOP: 6px
}
.w-S-body DL DT {
	DISPLAY: block; HEIGHT: 38px
}
.w-S-body DT LABEL {
	LINE-HEIGHT: 38px; PADDING-LEFT: 10px; WIDTH: 66px; FLOAT: left; FONT-WEIGHT: bold
}
.w-S-body DT SELECT {
	MARGIN-TOP: 10px; FLOAT: left
}
.w-S-body DT A {
	TEXT-ALIGN: center; LINE-HEIGHT: 25px; MARGIN: 6px 0px 0px; WIDTH: 75px; FLOAT: left; HEIGHT: 25px; OVERFLOW: hidden
}
.w-S-body DT .queren {
	BACKGROUND-POSITION: 0px 0px; COLOR: #2b53a5; MARGIN-LEFT: 80px
}
.w-S-body DT .quxiao {
	BACKGROUND-POSITION: 0px -26px; COLOR: #a52b2b; MARGIN-LEFT: 20px
}
.w-S-body .w-s-table {
	WIDTH: 100%
}
.w-S-body .w-s-table .left {
	LINE-HEIGHT: 30px; PADDING-LEFT: 10px; FONT-FAMILY: "微软雅黑"; WHITE-SPACE: nowrap; FONT-WEIGHT: bold
}
.w-S-body .w-s-table .middle {
	PADDING-BOTTOM: 4px; PADDING-LEFT: 0px; WIDTH: 350px; PADDING-RIGHT: 0px; PADDING-TOP: 4px
}
.w-S-body .w-s-table .middle .input-text {
	BORDER-BOTTOM: #aaa 1px solid; BORDER-LEFT: #aaa 1px solid; LINE-HEIGHT: 24px; BACKGROUND-COLOR: #fff; WIDTH: 345px; HEIGHT: 24px; BORDER-TOP: #aaa 1px solid; BORDER-RIGHT: #aaa 1px solid
}
.w-S-body .middle LABEL {
	LINE-HEIGHT: 24px; WIDTH: 110px; WHITE-SPACE: nowrap; FLOAT: left; COLOR: #666
}
.w-S-body .middle LABEL INPUT {
	POSITION: relative; MARGIN-RIGHT: 4px; TOP: 3px
}
.w-S-body .w-s-table .right {
	TEXT-ALIGN: center; WIDTH: 28px
}
.w-S-body .right A {
	WIDTH: 12px; ZOOM: 1; DISPLAY: inline-block; BACKGROUND-POSITION: -25px -52px; HEIGHT: 12px; OVERFLOW: hidden
}
.w-S-body .right .del {
	BACKGROUND-POSITION: -38px -52px
}
.w-S-body H5 {
	LINE-HEIGHT: 30px; PADDING-LEFT: 10px; WIDTH: 448px; MARGIN-BOTTOM: 3px; HEIGHT: 30px; FONT-WEIGHT: normal
}
.w-S-body H5 INPUT {
	BORDER-BOTTOM: #b5bdca 1px solid; BORDER-LEFT: #b5bdca 1px solid; LINE-HEIGHT: 18px; BACKGROUND-COLOR: #fff; WIDTH: 300px; HEIGHT: 18px; BORDER-TOP: #b5bdca 1px solid; BORDER-RIGHT: #b5bdca 1px solid
}
.w-S-body H5 .button {
	WIDTH: 46px; HEIGHT: 20px; MARGIN-LEFT: 10px
}
.w-S-body H6 {
	PADDING-BOTTOM: 5px; MARGIN: 0px auto; PADDING-LEFT: 0px; WIDTH: 460px; PADDING-RIGHT: 0px; COLOR: #666; FONT-SIZE: 12px; PADDING-TOP: 10px
}
.w-S-body P {
	LINE-HEIGHT: 20px; MARGIN: 0px auto; WIDTH: 460px; COLOR: #666; CLEAR: both
}
.w-S-body P STRONG {
	COLOR: #ff7e45; MARGIN-RIGHT: 5px
}
.w-S-body P SPAN {
	COLOR: #43c901
}
.w-S-body P EM {
	COLOR: #f00
}
.w-S-body P IMG {
	VERTICAL-ALIGN: middle
}

.FEeditorbg {
	PADDING-TOP: 3px
}
.narrow.FE_editor .FEeditorbg DL {
	BORDER-LEFT: medium none; HEIGHT: 47px; OVERFLOW: hidden; _width: 248px
}
.narrow.FE_editor .FEeditorbg DL DT {
	PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; WIDTH: 248px; PADDING-RIGHT: 0px; DISPLAY: block; FLOAT: none; HEIGHT: 18px; CLEAR: both; PADDING-TOP: 0px
}
.narrow.FE_editor .FEeditorbg DL DT A {
	DISPLAY: none
}
.narrow.FE_editor .FEeditorBody .FElist {
	PADDING-BOTTOM: 5px; WIDTH: 238px
}
.FE_editor .FEeditorbg .zhanweifuLi {
	DISPLAY: none
}
.windows-S .FEBox {
	MIN-WIDTH: 330px
}
.adds {
	DISPLAY: none !important
}
#ad_left {
	DISPLAY: none !important
}
#ad_right {
	DISPLAY: none !important
}
.ad960 {
	DISPLAY: none !important
}
#head_ad {
	DISPLAY: none !important
}
#top_ad {
	DISPLAY: none !important
}
#AdArea {
	DISPLAY: none !important
}
.a_mu {
	DISPLAY: none !important
}
#ad-2 {
	DISPLAY: none !important
}
.header_ad {
	DISPLAY: none !important
}
.sidebar_ads {
	DISPLAY: none !important
}
.top-content-adplace {
	DISPLAY: none !important
}
#topAd {
	DISPLAY: none !important
}
.ad_box {
	DISPLAY: none !important
}
#advt {
	DISPLAY: none !important
}
.adwords {
	DISPLAY: none !important
}
#adlayer {
	DISPLAY: none !important
}
#ads_c_tpc {
	DISPLAY: none !important
}
.a_pt {
	DISPLAY: none !important
}
.ad_footerbanner {
	DISPLAY: none !important
}
[id^='ad_thread'] {
	DISPLAY: none !important
}
.ads-bg {
	DISPLAY: none !important
}
#ad-container {
	DISPLAY: none !important
}
A[href^='http://sina.allyes.com/main/adfclick?'] {
	DISPLAY: none !important
}
#search_ad {
	DISPLAY: none !important
}
#content_adv {
	DISPLAY: none !important
}
.ad_content {
	DISPLAY: none !important
}
.ad_main {
	DISPLAY: none !important
}
#adtop {
	DISPLAY: none !important
}
.topadbox {
	DISPLAY: none !important
}
.adSpace {
	DISPLAY: none !important
}
.topads {
	DISPLAY: none !important
}
.ad-stack {
	DISPLAY: none !important
}
</STYLE>

<SCRIPT type=text/javascript>
   
    function AddAnswer() {
        
		var html = [];
		html.push("<dd>");
		html.push("    <table  class=\"w-s-table\">");
		html.push("        <tr>");
		html.push("            <td class=\"left\">答案内容：</td>");
		html.push("            <td class=\"middle\"><div class=\"FEBox\"></div></td>");
		html.push("            <td class=\"right\"><a href=\"javascript:;\" class=\"del\" onclick=\"$(this).parent().parent().parent().parent().parent().remove();\"></a></td>");
		html.push("        </tr>");
		html.push("        <tr>");
		html.push("            <td class=\"left\">答案属性：</td>");
		html.push("            <td class=\"middle\" colspan=\"2\">");
		html.push("                <label><input type=\"checkbox\" class=\"dxx\"   />区分大小写</label>");
		html.push("                <label><input type=\"checkbox\" class=\"zfth\"  />字符可替换</label>");
		html.push("                <label><input type=\"checkbox\" class=\"sxjs\"  />数值可换算</label>");
		html.push("                <label><input type=\"checkbox\" class=\"kdd\"   />顺序可颠倒</label>");
        html.push("                <label><input type=\"checkbox\" class=\"rg\" />人工判分</label>");
		html.push("            </td>");
		html.push("        </tr>");
		html.push("    </table>");
		html.push("</dd>");
		$("#duoguoWindows .w-S-body dd").last().after(html.join('\r\n'));
		$(".FEBox").each(function (i, o) {

		    if (typeof box != 'undefined') {
		        box.Init(o, (i + 1) * 1000);
		    }
		    else {
		        if (jQuery.browser.msie) {
		            o.setAttribute("contentEditable", true);
		        } else {
		            o.setAttribute("contenteditable", true);
		        }
		    }

		});
		//alert($("#duoguoWindows dd").length);
	}
	function multipleResultSubmit(win) {
	    var answerList = [];
	    var isRg = false;
	    $("#duoguoWindows .w-s-table").each(function () {
	        var aobj = {};
	        var answer = "";
	        var val = parser.Analyse($(this).find("div[class='FEBox']")[0]);
	        if (val.replace(/`/g, "") == '') return;
	        if (val.indexOf("root") > -1 || val.indexOf("sqrt") > -1 || val.indexOf("^") > -1 || val.indexOf("_") > -1 || val.indexOf("**") > -1 || val.indexOf("oparent") > -1 || val.indexOf("/") > -1 || val.indexOf("bar") > -1 || val.indexOf("{") > -1 || val.indexOf(">\\-") > -1 || val.indexOf("}") > -1 || val.indexOf("stackrel") > -1 || val.indexOf("ulul") > -1 || val.indexOf("rec") > -1 || val.indexOf("vec") > -1 || val.indexOf("[:") > -1 || val.indexOf("dot") > -1) {
	            answer = val;
	        } else {
	            answer = val.replace(/`/g, '').replace(/lt/g, '&lt;');
	        }


	        if (answer.length > 0) {
	            aobj.answer = answer;
	            aobj.attr = [];

	            $(this).find("input[type='checkbox']").each(function () {
	                if (this.checked) {
	                    if (this.className == "rg") {
	                        isRg = true;
	                    }
	                    aobj.attr.push(this.className);
	                }
	            });
	            answerList.push(aobj);
	        }

	    });
	    if (JSON.stringify(answerList) != "[]") {
	        var score = $("#AttrScore_Ten").val();
	        var answer = answerList[0].answer;

            /*
	        if (answer.indexOf("`") > -1) {
	            var dObj = document.createElement('div');
	            dObj.innerHTML = answer;
	            win.AMprocessNode(dObj, false);
	           
	            answer = dObj.innerHTML.replace(/m:/img, 'mml:')
	        }
			*/
				    }
	}

	function BindStatus(kongObj) {

	    $("#AttrScore_Ten option[value='" + kongObj.attr("inputScore") + "']").attr("selected", "selected");
	    var answer = kongObj.attr("inputAnswer");
	    var inputType = kongObj.attr("inputType");
	    if (inputType == "long-input") {
	        var table = $("#duoguoWindows .w-s-table:eq(0)");
	        var val = answer;
	        if (val.indexOf("root") > -1 || val.indexOf("sqrt") > -1 || val.indexOf("^") > -1 || val.indexOf("_") > -1 || val.indexOf("**") > -1 || val.indexOf("oparent") > -1 || val.indexOf("/") > -1 || val.indexOf("bar") > -1 || val.indexOf("{") > -1 || val.indexOf(">\\-") > -1 || val.indexOf("}") > -1 || val.indexOf("stackrel") > -1 || val.indexOf("ulul") > -1 || val.indexOf("rec") > -1 || val.indexOf("vec") > -1 || val.indexOf("[:") > -1 || val.indexOf("dot") > -1) {

	        } else {
	            table.find("div[class='FEBox']")[0].childNodes[0].innerHTML = val;
	        }
	        table.find("input[class='rg']").attr("checked", "checked");
	        return;
	    }
	    eval('var answer =' + kongObj.attr("inputAnswer"));
	    //alert($("#duoguoWindows table:eq(0)").html());
	    for (var i = 0; i < answer.length; i++) {
	        if (i > 0) {
	            AddAnswer();
            }

	        var table = $("#duoguoWindows .w-s-table:eq(" + i + ")");
            var val = answer[i].answer;
	        if (val.indexOf("root") > -1 || val.indexOf("sqrt") > -1 || val.indexOf("^") > -1 || val.indexOf("_") > -1 || val.indexOf("**") > -1 || val.indexOf("oparent") > -1 || val.indexOf("/") > -1 || val.indexOf("bar") > -1 || val.indexOf("{") > -1 || val.indexOf(">\\-") > -1 || val.indexOf("}") > -1 || val.indexOf("stackrel") > -1 || val.indexOf("ulul") > -1 || val.indexOf("rec") > -1 || val.indexOf("vec") > -1 || val.indexOf("[:") > -1 || val.indexOf("dot") > -1) {
	           
	        } else {
	            table.find("div[class='FEBox']")[0].childNodes[0].innerHTML = val;
	        }
	        
	        for (var j = 0; j < answer[i].attr.length; j++) {
	            table.find("input[class='" + answer[i].attr[j] + "']").attr("checked", "checked");
            }
        }
	}

    function InitAccessKey() {
        //数学符号
        KeyCode.create(document.getElementById("Fenshu"), str_to_num('(function(){box.Create("Fraction");})();'), 'alt+49');
        KeyCode.create(document.getElementById("Genhao"), str_to_num('(function(){box.Create("Sqrt");})();'), 'alt+50');
        KeyCode.create(document.getElementById("Genhaon"), str_to_num('(function(){box.Create("Sqrtn");})();'), 'alt+51');
        KeyCode.create(document.getElementById("Youshanbiao"), str_to_num('(function(){box.Create("SignRT");})();'), 'alt+52');
        KeyCode.create(document.getElementById("Youxiabiao"), str_to_num('(function(){box.Create("SignRB");})();'), 'alt+53');
        KeyCode.create(document.getElementById("Youlianbiao"), str_to_num('(function(){box.Create("SignRTB");})();'), 'alt+54');
        KeyCode.create(document.getElementById("Xunhuan"), str_to_num('(function(){box.Create("SignLoop");})();'), 'alt+55');
        KeyCode.create(document.getElementById("Pingjunshu"), str_to_num('(function(){box.Create("SignAvg");})();'), 'alt+56');
        KeyCode.create(document.getElementById("Xiangliang"), str_to_num('(function(){box.Create("SignVector");})();'), 'alt+57');
        KeyCode.create(document.getElementById("Hudu"), str_to_num('(function(){box.Create("SignArc");})();'), 'alt+48');
        KeyCode.create(document.getElementById("Limit"), str_to_num('(function(){box.Create("SignLimit");})();'), 'alt+112'); //F1
        KeyCode.create(document.getElementById("Sigema"), str_to_num('(function(){box.Create("SignMTB");})();'), 'alt+113'); //F2
        KeyCode.create(document.getElementById("Kuohao"), str_to_num('(function(){box.Create("Brackets");})();'), 'alt+114');
        KeyCode.create(document.getElementById("Juzhen1"), str_to_num('(function(){box.Create("Matrix12");})();'), 'alt+116');
        KeyCode.create(document.getElementById("Juzhen2"), str_to_num('(function(){box.Create("Matrix22");})();'), 'alt+118'); //F7
        KeyCode.create(document.getElementById("Fangcheng"), str_to_num('(function(){box.Create("Equa");})();'), 'alt+119'); //F8
        //物理化学符号
        KeyCode.create(document.getElementById("Rou"), str_to_num('(function(){box.Insert("ρ");})();'), 'alt+66', 'alt+66'); //+B
        KeyCode.create(document.getElementById("Miu"), str_to_num('(function(){box.Insert("μ");})();'), 'alt+71', 'alt+71'); //+G
        KeyCode.create(document.getElementById("Aita"), str_to_num('(function(){box.Insert("η");})();'), 'alt+73', 'alt+73'); //+I
        KeyCode.create(document.getElementById("Oumiga"), str_to_num('(function(){box.Insert("ω");})();'), 'alt+74', 'alt+74'); //+J
        KeyCode.create(document.getElementById("Yipuxilong"), str_to_num('(function(){box.Insert("ε");})();'), 'alt+75', 'alt+75'); //+K
        KeyCode.create(document.getElementById("Deerta"), str_to_num('(function(){box.Insert("Δ");})();'), 'alt+78', 'alt+78'); //+N
        KeyCode.create(document.getElementById("Aerfa"), str_to_num('(function(){box.Insert("α");})();'), 'alt+81', 'alt+81'); //+Q
        KeyCode.create(document.getElementById("Beita"), str_to_num('(function(){box.Insert("β");})();'), 'alt+85', 'alt+85'); //+U
        KeyCode.create(document.getElementById("Gama"), str_to_num('(function(){box.Insert("γ");})();'), 'alt+88', 'alt+88'); //+X
        KeyCode.create(document.getElementById("Foai"), str_to_num('(function(){box.Insert("φ");})();'), 'alt+89', 'alt+89'); //+Y
        KeyCode.create(document.getElementById("Citongliang"), str_to_num('(function(){box.Insert("Φ");})();'), 'alt+9', 'alt+57+shift');
        KeyCode.create(document.getElementById("Oumo"), str_to_num('(function(){box.Insert("Ω");})();'), 'alt+10', 'alt+48+shift');
        KeyCode.create(document.getElementById("Bochang"), str_to_num('(function(){box.Insert("λ");})();'), 'alt+11', 'alt+112+shift');
        KeyCode.create(document.getElementById("Ai"), str_to_num('(function(){box.Insert("Å");})();'), 'alt+12', 'alt+113+shift');
        KeyCode.create(document.getElementById("banshuaiqi"), str_to_num('(function(){box.Insert("τ");})();'), 'alt+13', 'alt+114+shift');
        KeyCode.create(document.getElementById("Pinglv"), str_to_num('(function(){box.Insert("ν");})();'), 'alt+14', 'alt+116+shift');


        KeyCode.create(document.getElementById("ZuoshangH"), str_to_num('(function(){box.Create("SignLT");})();'), 'alt+120'); //F9
        KeyCode.create(document.getElementById("ZuoxiaH"), str_to_num('(function(){box.Create("SignLB");})();'), 'alt+121'); //F10
        KeyCode.create(document.getElementById("SigeH"), str_to_num('(function(){box.Create("SignLRTB");})();'), 'alt+122'); //F11
        KeyCode.create(document.getElementById("DingbuH"), str_to_num('(function(){box.Create("SignMT");})();'), 'alt+123'); //F12
        KeyCode.create(document.getElementById("DingyouxiaH"), str_to_num('(function(){box.Create("SignMTRB");})();'), 'alt+1', 'alt+49+shift');
        KeyCode.create(document.getElementById("Huaxue2"), str_to_num('(function(){box.Create("Chemistry2");})();'), 'alt+2', 'alt+50+shift');
        KeyCode.create(document.getElementById("Huaxue3"), str_to_num('(function(){box.Create("Chemistry3");})();'), 'alt+3', 'alt+51+shift');
        KeyCode.create(document.getElementById("Huaxue4"), str_to_num('(function(){box.Create("Chemistry4");})();'), 'alt+4', 'alt+52+shift');
        KeyCode.create(document.getElementById("FE_Peiping"), str_to_num('(function(){box.Create("Vary");})();'), 'alt+5', 'alt+53+shift');

        //特殊符号   
        KeyCode.create(document.getElementById("Kexi"), str_to_num('(function(){box.Insert("ξ");})();'), 'alt+6', 'alt+54+shift');
        KeyCode.create(document.getElementById("Xita"), str_to_num('(function(){box.Insert("θ");})();'), 'alt+7', 'alt+55+shift');
        KeyCode.create(document.getElementById("Deerta_teX"), str_to_num('(function(){box.Insert("δ");})();'), 'alt+8', 'alt+56+shift');
    }

    function FE_Minimized() {
        jQuery('#FE_ico').fadeIn("slow");
        //这里需要加上动态收起效果
        jQuery('#FE_editor').fadeOut("slow"); ;
    }

    function FE_Close() {
        jQuery('#FE_ico').fadeIn("slow");
        jQuery('#FE_editor').fadeOut("slow"); ;
    }

    //sign: 0 数学，1 理化, 2 特殊符号
    function FE_Change_Sign(sign) {
        jQuery('#FE_maths_list,#FE_physics_list,#FE_signs_list').hide();
        jQuery('#FE_maths').attr('class', 'FE_maths');
        jQuery('#FE_physics').attr('class', 'FE_physics');
        jQuery('#FE_signs').attr('class', 'FE_signs');
        switch (sign) {
            case 0:
                jQuery('#FE_maths_list').css('display', 'block');
                jQuery('#FE_maths').attr('class', 'FE_maths hot');
                break;
            case 1:
                jQuery('#FE_physics_list').css('display', 'block');
                jQuery('#FE_physics').attr('class', 'FE_physics hot');
                break;
            case 2:
                jQuery('#FE_signs_list').css('display', 'block');
                jQuery('#FE_signs').attr('class', 'FE_signs hot');
                break;
        }
    }

    //initSubId: 0 数学，1 理化
    function FE_ico_Click(initSubId) {
        FE_Change_Sign(initSubId);
        jQuery('#FE_ico').hide();
        //这里需要加上动态展开效果和坐标定位
        Set_FEOffset();

    }
    function Set_FEOffset() {

        var fe = box.FEBox;
        var id = fe.id.substring(2, 17);
        var ofSet = jQuery(fe).offset();
        var icoOfSet = jQuery("#FE_ico").offset();
        var feW = jQuery("#FE_editor").width();
        var feH = jQuery("#FE_editor").height();
        var icoW = jQuery("#FE_ico").width();
        var icoH = jQuery("#FE_ico").height();
        // debugger;
        var l = ofSet.left;
        var t = ofSet.top - 5;

        t = t - feH;

        /* jQuery('#FE_editor').css({left:icoOfSet.left,top:icoOfSet.top,width:icoW,height:icoH}).animate(
        {left:l,top:t,height:feH,width:feW,opacity: 'show'},{duration:500}
        );*/
        jQuery('#FE_editor').css({ left: l, top: t }).fadeIn("slow");
    }

    function FE_Clear() {
        var length = box.FEBox.childNodes.length;
        while (box.FEBox.firstChild !== box.FEBox.lastChild) {
            box.FEBox.removeChild(box.FEBox.lastChild);
        }

        var elem = box.FEBox.firstChild;
        elem.innerHTML = '';
        elem.className = elem.getAttribute('clsName');
        box.SetFocus(elem);
    }

    window.onload = function () {
        var textBox = document.getElementById('FEBox');

        //循环页面中所有空调用以下方法，textBox为各个空实例
        box.Init(textBox, 1000); //1000为各空的基值，两空间的差数为1000
        textBox.click();


        if (typeof KeyCode != 'undefined') {
            InitAccessKey();
        }
        /*
        var css = '/css/FormulaEditorForAll.css';
        if ($.browser.msie) {
            if (parseInt(jQuery.browser.version) == 7) {
                css = '/css/FormulaEditorForIE7.css';
            }
        }
        document.getElementById("skin").href = css;
*/

        //document.getElementById("FEBox").focus();
        //jQuery('#FE_Peiping').css('visibility', 'hidden');

        //        jQuery("#FE_ico").mouseover(function () {
        //            jQuery(this).animate({ opacity: 1 }, { duration: 500 })
        //        }).mouseout(function () {
        //            jQuery(this).animate({ opacity: 0.5 }, { duration: 1000 })
        //        });
        //        if (typeof box != 'undefined') {
        //            //实现空的click函数，定位FE_ico和FE_editor

        //            box.Click = function () {
        //                //当前空box.FEBox	
        //                var offSet = jQuery(box.FEBox).offset();
        //                // var currentIcoOffSet = jQuery("#FE_ico").offSet();
        //                var l, t;
        //                l = offSet.left - 25;
        //                t = offSet.top - 20;

        //                /*
        //                jQuery('#FE_ico').css('left',l);
        //                jQuery('#FE_ico').css('top',t);*/

        //                if (jQuery('#FE_editor').css('display') == 'none') {
        //                    jQuery("#FE_ico").animate({
        //                        left: l, top: t, opacity: 1
        //                    }, { duration: 500 }).fadeIn("slow").animate(
        //                                { opacity: 0.6 }, { duration: 1000 }
        //                             );
        //                } else {
        //                    Set_FEOffset();
        //                }
        //            }
        //        }
    }
</SCRIPT>


<META name=GENERATOR content="MSHTML 9.00.8112.16514"></HEAD>
<BODY>
<DIV style="DISPLAY: block" id=duoguoWindows class=windows-S>
<DIV class=w-S-body><!--h3 id="duoguoDragElement" style="cursor:move;"><a href="javascript:;" onclick="window.close();"></a>编辑空答案</h3-->
<H4>提示：如果答案存在多种可能，请点击右边的“+”继续添加答案。</H4>
<DL>
  <DD>
  <TABLE class=w-s-table>
    <TBODY>
    <TR>
      <TD class=left>答案内容：</TD>
      <TD class=middle><!--<input class="input-text" type="text" />-->
        <DIV id=FEBox class=FEBox></DIV></TD>
      <TD class=right><A onclick=AddAnswer(); href="javascript:;"></A></TD></TR>
    <TR>
      <TD class=left>答案属性：</TD>
      <TD class=middle colSpan=2><LABEL><INPUT class=dxx 
        type=checkbox>区分大小写</LABEL> <LABEL><INPUT class=zfth 
        type=checkbox>字符可替换</LABEL> <LABEL><INPUT class=sxjs 
        type=checkbox>数值可换算</LABEL> <LABEL><INPUT class=kdd 
        type=checkbox>顺序可颠倒</LABEL> <LABEL><INPUT class=rg 
        type=checkbox>人工判分</LABEL> </TD></TR></TBODY></TABLE></DD>
  <DT><LABEL>答案分值：</LABEL> <SELECT id=AttrScore_Ten> <OPTION 
    value=0.25>0.25</OPTION> <OPTION value=0.5>0.5</OPTION> <OPTION selected 
    value=1>1</OPTION> <OPTION value=1.5>1.5</OPTION> <OPTION value=2>2</OPTION> 
    <OPTION value=2.5>2.5</OPTION> <OPTION value=3>3</OPTION> <OPTION 
    value=3.5>3.5</OPTION> <OPTION value=4>4</OPTION> <OPTION 
    value=4.5>4.5</OPTION> <OPTION value=5>5</OPTION> <OPTION 
    value=5.5>5.5</OPTION> <OPTION value=6>6</OPTION> <OPTION 
    value=6.5>6.5</OPTION> <OPTION value=7>7</OPTION> <OPTION 
    value=7.5>7.5</OPTION> <OPTION value=8>8</OPTION> <OPTION 
    value=8.5>8.5</OPTION> <OPTION value=9>9</OPTION> <OPTION 
    value=9.5>9.5</OPTION> <OPTION value=10>10</OPTION></SELECT> <!--
                    <a class="queren" href="javascript:;" onclick="multipleResultSubmit();">确 认</a><a class="quxiao" href="javascript:;" onclick="window.close();">取 消</a>
                    --></DT></DL>
<H6>小贴示：</H6>
<P><STRONG>区分大小写：</STRONG>例，答案为"<SPAN>Helllo</SPAN>"不可写为"<EM>hello</EM>"</P>
<P><STRONG>字符可替换：</STRONG>例，答案为“<SPAN>a，b</SPAN>”也可写成“<SPAN>a；b</SPAN>”“<SPAN>a、b</SPAN>”“<SPAN>a和b</SPAN>”“<SPAN>a与b</SPAN>”</P>
<P><STRONG>数值可换算：</STRONG>例，答案为"<SPAN><IMG alt="" 
src="fenshu.png"></SPAN>"等同于"<SPAN>1.5</SPAN>"</P>
<P><STRONG>顺序可颠倒：</STRONG>例，答案为“<SPAN>A、B、C</SPAN>”用户写成"<SPAN>B、A、C</SPAN>"也算对</P>
<P><STRONG>人工判分　：</STRONG>选择本项后，老师判分或让学生自主判分</P></DIV>
<DIV class=w-s-Febox>
<DIV style="DISPLAY: block" id=FE_editor class="FE_editor narrow"><IFRAME 
src="about:blank" frameBorder=0></IFRAME>
<DIV class=FEeditorbg>
<DL id=FEeditorbg>
  <DT><A class=FE_close title=关闭 onClick="FE_Close();return false;" 
  href="javascript:;"></A><SPAN>公式编辑器</SPAN></DT>
  <DD><A id=FE_maths class="FE_maths hot" 
  onclick="FE_Change_Sign(0);return false;" href="javascript:;">数学符号</A></DD>
  <DD><A id=FE_physics class=FE_physics 
  onclick="FE_Change_Sign(1);return false;" href="javascript:;">物理化学</A></DD>
  <DD><A id=FE_signs class=FE_signs onClick="FE_Change_Sign(2);return false;" 
  href="javascript:;">特殊符号</A></DD></DL>
<DIV class=FEeditorBody>
<UL style="DISPLAY: block" id=FE_maths_list class=FElist>
  <LI><A class=Jiahao title=加号 onClick="box.Insert('+');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Jianhao title=减号 onClick="box.Insert('-');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chenghao title=乘号 onClick="box.Insert('×');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chuhao title=除号 onClick="box.Insert('÷');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Diancheng title=点乘 onClick="box.Insert('·');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Xiaoyu title=小于 onClick="box.Insert('＜');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Dayu title=大于 onClick="box.Insert('>');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Xiaoyudengyu title=小于等于 onClick="box.Insert('≤');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Dayudengyu title=大于等于 onClick="box.Insert('≥');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Yuedengyu title=约等于 onClick="box.Insert('≈');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Budengyu title=不等于 onClick="box.Insert('≠');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Yuanzhoulv title=圆周率 onClick="box.Insert('π');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Wuqiongda title=无穷大 onClick="box.Insert('∞');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Yinwei title=因为 onClick="box.Insert('∵');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Suoyi title=所以 onClick="box.Insert('∴');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Tuichu title=推出 onClick="box.Insert('⇒');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Dengjiayu title=等价于 onClick="box.Insert('⇔');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quandengyu title=全等于 onClick="box.Insert('≌');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Xiangsiyu title=相似于 onClick="box.Insert('∽');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Pingxing title=平行 onClick="box.Insert('∥');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chuizhi title=垂直 onClick="box.Insert('⊥');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Jiaodu title=角 onClick="box.Insert('∠');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Sanjiaoxing title=三角形 onClick="box.Insert('△');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Sibianxing title=平行四边形 onClick="box.Insert('▱');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Yuan title=圆 onClick="box.Insert('⊙');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Shuyu title=属于 onClick="box.Insert('∈');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Bushuyu title=不属于 onClick="box.Insert('∉');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Kongji title=空集 onClick="box.Insert('∅');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Baohuanyu title=包含于 onClick="box.Insert('⊂');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Baohan title=包含 onClick="box.Insert('⊃');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Bingji title=并集 onClick="box.Insert('∪');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Jiaoji title=交集 onClick="box.Insert('∩');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Baohuanyu2 title=包含于 onClick="box.Insert('⊆');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Baohan2 title=包含 onClick="box.Insert('⊇');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Bubaohanyu title=不包含于 onClick="box.Insert('⊄');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Bubaohan title=不包含 onClick="box.Insert('⊅');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Bubaohanyu2 title=不包含于 onClick="box.Insert('⊈');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Bubaohan2 title=不包含 onClick="box.Insert('⊉');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Zhenbaohanyu title=真包含于 onClick="box.Insert('⊊');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Zhenbaohan title=真包含 onClick="box.Insert('⊋');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Buji title=补集 onClick="box.Insert('∁');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=quandy_sx title=恒等于 onClick="box.Insert('≡');return false;" 
  href="javescript:;"></A></LI>
  <LI class=zhanweifuLi><A class=zhanweifu title="" 
href="javascript:;"></A></LI>
  <LI class=zhanweifuLi><A class=zhanweifu title="" 
href="javascript:;"></A></LI>
  <LI class=zhanweifuLi><A class=zhanweifu title="" 
href="javascript:;"></A></LI>
  <LI><A id=Fenshu class=Fenshu title="分数 ALT+1" 
  onclick="box.Create('Fraction');return false;" href="javascript:;"></A></LI>
  <LI><A id=Genhao class=Genhao title="根号 ALT+2" 
  onclick="box.Create('Sqrt');return false;" href="javascript:;"></A></LI>
  <LI><A id=Genhaon class=Genhaon title="N次根号 ALT+3" 
  onclick="box.Create('Sqrtn');return false;" href="javascript:;"></A></LI>
  <LI><A id=Youshanbiao class=Youshangbiao title="右上标 ALT+4" 
  onclick="box.Create('SignRT');return false;" href="javascript:;"></A></LI>
  <LI><A id=Youxiabiao class=Youxiabiao title="右下标 ALT+5" 
  onclick="box.Create('SignRB');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Youlianbiao class=Youliangbiao title="右标 ALT+6" 
  onclick="box.Create('SignRTB');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Xunhuan class=Xunhuan title="循环 ALT+7" 
  onclick="box.Create('SignLoop');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Pingjunshu class=Pingjunshu title="平均数 ALT+8" 
  onclick="box.Create('SignAvg');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Xiangliang class=Xiangliang title="向量 ALT+9" 
  onclick="box.Create('SignVector');;return false;" 
href="javascript:;"></A></LI>
  <LI><A id=Hudu class=Hudu title="弧度 ALT+0" 
  onclick="box.Create('SignArc');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Limit class=Limit title="limit ALT+F1" 
  onclick="box.Create('SignLimit');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Sigema class=Sigema title="求和 ALT+F2" 
  onclick="box.Create('SignMTB');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Kuohao class=Kuohao title="长括号 ALT+F3" 
  onclick="box.Create('Brackets');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Juzhen1 class=Juzhen1 title="1列矩阵 ALT+F5" 
  onclick="box.Create('Matrix12');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Juzhen2 class=Juzhen2 title="2列矩阵 ALT+F7" 
  onclick="box.Create('Matrix22');;return false;" href="javascript:;"></A></LI>
  <LI><A id=Fangcheng class=Fangchegn title="方程组 ALT+F8" 
  onclick="box.Create('Equa');;return false;" href="javascript:;"></A></LI>
  <LI><A class=Qingkong1 title=清空 onClick="FE_Clear();return false;" 
  href="javascript:;"></A></LI></UL>
<UL id=FE_physics_list class=FElist>
  <LI><A class=Jiahao title=加号 onClick="box.Insert('+');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Jianhao title=减号 onClick="box.Insert('-');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chenghao title=乘号 onClick="box.Insert('×');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chuhao title=除号 onClick="box.Insert('÷');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Diancheng title=点乘 onClick="box.Insert('·');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Xiaoyu title=小于 onClick="box.Insert('＜');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Dayu title=大于 onClick="box.Insert('>');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Xiaoyudengyu title=小于等于 onClick="box.Insert('≤');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Dayudengyu title=大于等于 onClick="box.Insert('≥');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Yuedengyu title=约等于 onClick="box.Insert('≈');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Budengyu title=不等于 onClick="box.Insert('≠');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Shishidu title=摄氏度 onClick="box.Insert('℃');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Huashidu title=华氏度 onClick="box.Insert('℉');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Tantanshuang title=碳碳双键 onClick="box.Insert('＝');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Tantansan title=碳碳三键 onClick="box.Insert('≡');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Qiti title=气体 onClick="box.Insert('↑');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chendian title=沉淀 onClick="box.Insert('↓');return false;" 
  href="javascript:;"></A></LI>
  <LI><A id=Rou class=Rou title="希腊字母 ALT+B" 
  onclick="box.Insert('ρ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Miu class=Miu title="希腊字母 ALT+G" 
  onclick="box.Insert('μ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Aita class=Aita title="希腊字母 ALT+I" 
  onclick="box.Insert('η');return false;" href="javascript:;"></A></LI>
  <LI><A id=Oumiga class=Oumiga title="希腊字母 ALT+J" 
  onclick="box.Insert('ω');return false;" href="javascript:;"></A></LI>
  <LI><A id=Yipuxilong class=Yipuxilong title="希腊字母 ALT+K" 
  onclick="box.Insert('ε');return false;" href="javascript:;"></A></LI>
  <LI><A id=Deerta class=Deerta title="希腊字母 ALT+N" 
  onclick="box.Insert('Δ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Aerfa class=Aerfa title="希腊字母 ALT+Q" 
  onclick="box.Insert('α');return false;" href="javascript:;"></A></LI>
  <LI><A id=Beita class=Beita title="希腊字母 ALT+U" 
  onclick="box.Insert('β');return false;" href="javascript:;"></A></LI>
  <LI><A id=Gama class=Gama title="希腊字母 ALT+X" 
  onclick="box.Insert('γ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Foai class=Foai title="希腊字母 ALT+Y" 
  onclick="box.Insert('φ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Oumo class=Oumo title="欧姆 ALT+SHIFT+0" 
  onclick="box.Insert('Ω');return false;" href="javascript:;"></A></LI>
  <LI><A id=Citongliang class=Citongliang title="磁通量 ALT+SHIFT+9" 
  onclick="box.Insert('Φ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Bochang class=Bochang title="波长 ALT+SHIFT+F1" 
  onclick="box.Insert('λ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Ai class=Ai title="埃 ALT+SHIFT+F2" 
  onclick="box.Insert('Å');return false;" href="javascript:;"></A></LI>
  <LI><A id=banshuaiqi class=banshuaiqi title="半衰期 ALT+SHIFT+F3" 
  onclick="box.Insert('τ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Pinglv class=Pinglv title="频率 ALT+SHIFT+F5" 
  onclick="box.Insert('ν');return false;" href="javascript:;"></A></LI>
  <LI><A class=lihua001></A></LI>
  <LI><A class=lihua002></A></LI>
  <LI><A class=lihua003></A></LI>
  <LI><A class=lihua004></A></LI>
  <LI><A class=lihua005></A></LI>
  <LI><A class=lihua006></A></LI>
  <LI><A class=lihua007></A></LI>
  <LI><A class=lihua008></A></LI>
  <LI><A class=lihua009></A></LI>
  <LI><A id=YoushangH class=YoushangH title="右上标 ALT+4" 
  onclick="box.Create('SignRT');return false;" href="javascript:;"></A></LI>
  <LI><A id=YouxiaH class=YouxiaH title="右下标 ALT+5" 
  onclick="box.Create('SignRB');return false;" href="javascript:;"></A></LI>
  <LI><A id=YouliangH class=YouliangH title="右双标 ALT+6" 
  onclick="box.Create('SignRTB');return false;" href="javascript:;"></A></LI>
  <LI><A id=ZuoshangH class=ZuoshangH title="左上标 ALT+F9" 
  onclick="box.Create('SignLT');return false;" href="javascript:;"></A></LI>
  <LI><A id=ZuoxiaH class=ZuoxiaH title="左下标 ALT+F10" 
  onclick="box.Create('SignLB');return false;" href="javascript:;"></A></LI>
  <LI><A id=SigeH class=SigeH title="四角标 ALT+F11" 
  onclick="box.Create('SignLRTB');return false;" href="javascript:;"></A></LI>
  <LI><A id=DingbuH class=DingbuH title="顶标 ALT+F12" 
  onclick="box.Create('SignMT');return false;" href="javascript:;"></A></LI>
  <LI><A id=DingyouxiaH class=DingyouxiaH title="顶、右下标 ALT+SHIFT+1" 
  onclick="box.Create('SignMTRB');return false;" href="javascript:;"></A></LI>
  <LI><A id=Huaxue1 class=Huaxue1 title=特殊符号 
  onclick="box.Create('Chemistry1');return false;" href="javascript:;"></A></LI>
  <LI><A id=Huaxue2 class=Huaxue2 title="特殊符号 ALT+SHIFT+2" 
  onclick="box.Create('Chemistry2');return false;" href="javascript:;"></A></LI>
  <LI><A id=Huaxue3 class=Huaxue3 title="特殊符号 ALT+SHIFT+3" 
  onclick="box.Create('Chemistry3');return false;" href="javascript:;"></A></LI>
  <LI><A id=Huaxue4 class=Huaxue4 title="特殊符号 ALT+SHIFT+4" 
  onclick="box.Create('Chemistry4');return false;" href="javascript:;"></A></LI><%--<li><a id="FE_Peiping" class="Peiping" href="javascript:;" title="化学配平 ALT+SHIFT+5" onclick="box.Create('Vary');return false;"></a></li>
                        <li><a class="huaxue001"></a></li>--%>
  <LI><A class=Qingkong2 title=清空 onClick="FE_Clear();return false;" 
  href="javascript:;"></A></LI></UL>
<UL id=FE_signs_list class=FElist><%--<li><a class="Log" href="javascript:;" title="log" onclick="box.Insert('㏒');return false;"></a></li>
                        <li><a class="Ln" href="javascript:;" title="ln" onclick="box.Insert('㏑');return false;"></a></li>--%>
  <LI><A class=Jifen title=积分 onClick="box.Insert('∫');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Dushu title=度 onClick="box.Insert('°');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Fenzhong title=分 onClick="box.Insert('′');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Miaozhong title=秒 onClick="box.Insert('″');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Qianfenbi title=千分号 onClick="box.Insert('‰');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Shishidu_te title=摄氏度 onClick="box.Insert('℃');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Huashidu_te title=华氏度 onClick="box.Insert('℉');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Jiajian title=加减 onClick="box.Insert('±');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Jianjia title=减加 onClick="box.Insert('∓');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Qie title=且 onClick="box.Insert('∧');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Huo title=或 onClick="box.Insert('∨');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Shangsheng title=上升 onClick="box.Insert('↗');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Xiajiang title=下降 onClick="box.Insert('↘');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Budayu title=不大于 onClick="box.Insert('≯');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Buxiaoyu title=不小于 onClick="box.Insert('≮');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Hengdengyu title=恒等于 onClick="box.Insert('≡');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Chengzhengbi title=成正比 onClick="box.Insert('∝');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Qiuji title=求积 onClick="box.Insert('∏');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Wuqiongxiao title="无穷小 ALT+K" 
  onclick="box.Insert('ε');return false;" href="javascript:;"></A></LI>
  <LI><A id=Kexi class=Kexi title="希腊字母 ALT+SHIFT+6" 
  onclick="box.Insert('ξ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Miu_te title="希腊字母 ALT+G" onClick="box.Insert('μ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Deerta_te title="希腊字母 ALT+N" 
  onclick="box.Insert('Δ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Aerfa_tr title="希腊字母 ALT+Q" 
  onclick="box.Insert('α');return false;" href="javascript:;"></A></LI>
  <LI><A class=Beita_te title="希腊字母 ALT+U" 
  onclick="box.Insert('β');return false;" href="javascript:;"></A></LI>
  <LI><A class=Gama_te title="希腊字母 ALT+X" 
  onclick="box.Insert('γ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Rou_te title="希腊字母 ALT+B" onClick="box.Insert('ρ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=lanbuda_te title="希腊字母 ALT+SHIFT+F1" 
  onclick="box.Insert('λ');return false;" href="javascript:;"></A></LI>
  <LI><A id=Deerta_teX class=Deerta_teX title="希腊字母 ALT+SHIFT+8" 
  onclick="box.Insert('δ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Oumiga_te title="希腊字母 ALT+J" 
  onclick="box.Insert('ω');return false;" href="javascript:;"></A></LI>
  <LI><A class=Foai_te title="希腊字母 ALT+SHIFT+9" 
  onclick="box.Insert('Φ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Foai_teX title="希腊字母 ALT+Y" 
  onclick="box.Insert('φ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Aita_te title="希腊字母 ALT+I" 
  onclick="box.Insert('η');return false;" href="javascript:;"></A></LI>
  <LI><A id=Xita class=Xita_te title="希腊字母 ALT+SHIFT+7" 
  onclick="box.Insert('θ');return false;" href="javascript:;"></A></LI>
  <LI><A class=Quan1 title=数字序号1 onClick="box.Insert('①');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan2 title=数字序号2 onClick="box.Insert('②');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan3 title=数字序号3 onClick="box.Insert('③');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan4 title=数字序号4 onClick="box.Insert('④');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan5 title=数字序号5 onClick="box.Insert('⑤');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan6 title=数字序号6 onClick="box.Insert('⑥');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan7 title=数字序号7 onClick="box.Insert('⑦');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan8 title=数字序号8 onClick="box.Insert('⑧');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan9 title=数字序号9 onClick="box.Insert('⑨');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Quan10 title=数字序号10 onClick="box.Insert('⑩');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma1 title=罗马数字1 onClick="box.Insert('Ⅰ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma2 title=罗马数字2 onClick="box.Insert('Ⅱ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma3 title=罗马数字3 onClick="box.Insert('Ⅲ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma4 title=罗马数字4 onClick="box.Insert('Ⅳ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma5 title=罗马数字5 onClick="box.Insert('Ⅴ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma6 title=罗马数字6 onClick="box.Insert('Ⅵ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma7 title=罗马数字7 onClick="box.Insert('Ⅶ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma8 title=罗马数字8 onClick="box.Insert('Ⅷ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma9 title=罗马数字9 onClick="box.Insert('Ⅸ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Luoma10 title=罗马数字10 onClick="box.Insert('Ⅹ');return false;" 
  href="javascript:;"></A></LI>
  <LI><A class=Te001></A></LI>
  <LI><A class=Te002></A></LI>
  <LI><A class=Te003></A></LI>
  <LI><A class=Te004></A></LI>
  <LI><A class=Te005></A></LI>
  <LI><A class=Te006></A></LI>
  <LI><A class=Te006></A></LI>
  <LI><A class=Te006></A></LI>
  <LI><A class=Qingkong_te title=清空 onClick="FE_Clear();return false;" 
  href="javascript:;"></A></LI></UL>
<DIV class=clear></DIV></DIV></DIV></DIV></DIV></DIV>
<DIV id=FE_ico 
class=FE_ico><!--FE_ico_Click:参数设定打开公式编辑器时默认为数学还是理化，0：数学 1：理化--><A title=打开公式编辑器 
onclick="FE_ico_Click(0);return false;" href="javascript:;"></A></DIV>
</BODY></HTML>
