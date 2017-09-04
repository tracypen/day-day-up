/*******************************************************************************
* KindEditor - WYSIWYG HTML Editor for Internet
* Copyright (C) 2006-2011 kindsoft.net
*
* @author Roddy <luolonghao@gmail.com>
* @site http://www.kindsoft.net/
* @licence http://www.kindsoft.net/license.php
*******************************************************************************/

// Baidu Maps: http://dev.baidu.com/wiki/map/index.php?title=%E9%A6%96%E9%A1%B5

KindEditor.plugin('FEBox', function (K) {
    var self = this, name = 'FEBox';
    self.clickToolbar(name, function () {
        var html = ['<div style="padding:5px;">',
			'<div class="ke-map" style="width:580px;height:270px;overflow:auto;"></div>',
			'</div>'].join('');
        var dialog = self.createDialog({
            name: name,
            width: 590,
            title: self.lang(name),
            body: html,
            yesBtn: {
                name: '插入公式',
                click: function (e) {
                    var ml = win.parser.Analyse(win.document.getElementById("FEBox"));
                    if (ml.replace(/`/g, "") == '') {
                        alert("请输入公式！");
                    } else {
                        ml = formatMathMLString(ml);
                        if (ml.indexOf("`") > -1) {
                            var dObj = document.createElement('div');
                            dObj.innerHTML = ml;
                           win.AMprocessNode(dObj, false);
                            self.insertHtml(dObj.innerHTML.replace(/m:/img, 'mml:') + "&#160;");
                            //重新赋值，使公式可以正常显示
                            self.html(self.html());
                        } else {
                            self.insertHtml(ml);
                        }
                        self.hideDialog().focus();
                    }
                }
            },
            beforeRemove: function () {
                if (doc) {
                    doc.write('');
                }
                iframe.remove();
            }
        });
        var div = dialog.div,
			febox = K('[id="FEBox"]', div),
			win, doc;
        var iframe = K('<iframe class="ke-textarea" frameborder="0" src="'+ctx+'/questions/fee" style="width:580px;height:270px;border:#ffffff solid 1px;"></iframe>');
        function ready() {
            win = iframe[0].contentWindow;
            doc = K.iframeDoc(iframe);
        }
        iframe.bind('load', function () {
            iframe.unbind('load');
            if (K.IE) {
                ready();
            } else {
                setTimeout(ready, 0);
            }
        });
        K('.ke-map', div).replaceWith(iframe);

        function formatMathMLString(val) {
            if (val.indexOf("root") > -1 || val.indexOf("sqrt") > -1 ||
			   val.indexOf("^") > -1 || val.indexOf("_") > -1 || val.indexOf("**") > -1 ||
			   val.indexOf("oparent") > -1 || val.indexOf("/") > -1 ||
			   val.indexOf("bar") > -1 || val.indexOf("{") > -1 || val.indexOf(">\\-") > -1 ||
			   val.indexOf("}") > -1 || val.indexOf("stackrel") > -1 ||
			   val.indexOf("ulul") > -1 || val.indexOf("rec") > -1 || val.indexOf("vec") > -1 ||
			   val.indexOf("[:") > -1 || val.indexOf("dot") > -1) {
                return val;
            } else {
                return val.replace(/`/g, '');
            }
        }

    });
});
