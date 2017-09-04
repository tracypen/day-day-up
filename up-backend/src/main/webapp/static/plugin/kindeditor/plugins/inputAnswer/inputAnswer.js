KindEditor.plugin('inputAnswer', function (K) {
    var self = this, name = 'inputAnswer';

    self.plugin.getSelectedinputAnswer = function () {
        return self.cmd.commonAncestor('inputanswer');
    };
    $('edit,delete'.split(',')).each(function (j, val) {
        //alert(1);
        self.addContextmenu({
            title: val == 'edit' ? '编辑题目空' : '删除题目空',
            click: function () {
                self.loadPlugin('inputAnswer', function () {
                    self.plugin['inputAnswer'][val]();
                    self.hideMenu();
                });
            },
            cond: self.plugin["getSelectedinputAnswer"],
            width: 150,
            iconClass: undefined
        });
        self.addContextmenu({ title: '-' });
    });

    self.plugin.inputAnswer = {
        edit: function () {
            var kongObj = self.plugin.getSelectedinputAnswer();
            self.plugin.insertAnswerFunction(kongObj);
        },
        'delete': function () {
            var kongObj = self.plugin.getSelectedinputAnswer();
            if (kongObj) {
                kongObj.remove();
                kongObj = null;
            }
            self.focus();
        }
    }
    self.plugin.insertAnswerFunction = function (kongObj) {
        var html = ['<div>',
			'<div class="ke-map" style="width:755px;height:355px;overflow:auto;"></div>',
			'</div>'].join('');
        var dialog = self.createDialog({
            name: name,
            width: 755,
            title: self.lang(name),
            body: html,
            yesBtn: {
                name: '插入答案',
                click: function (e) {
                    var className = 'otherInput';
                    var ml = win.multipleResultSubmit(window);
                    if (kongObj) {
                        //alert(kongObj[0].outerHTML);
                        kongObj.replaceWith(ml);
                    } else {
                        self.insertHtml(ml);
                    }
                    self.html(self.html());
                    self.hideDialog().focus();
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
			febox = K('[id="duoguoWindows"]', div),
			win, doc;
        var iframe = K('<iframe class="ke-textarea" frameborder="0" src="' + self.pluginsPath + 'inputAnswer/answer.jsp" style="width:100%;height:355px;border:#ffffff solid 0px;"></iframe>');
        function ready() {
            win = iframe[0].contentWindow;
            doc = K.iframeDoc(iframe);
            if (kongObj) {
                win.BindStatus(kongObj);
            }
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
    }
    self.clickToolbar(name, function () {
        self.plugin.insertAnswerFunction(null);

    });
});