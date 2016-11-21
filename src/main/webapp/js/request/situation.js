/**
 * Created by yizijun on 2016/11/21 0021.
 */
//初始化发布动态编辑器
var situationEditor = UE.getEditor('situation-container', {
    initialFrameWidth: 698,
    initialFrameHeight:340,
    autoHeightEnabled: false,
    autoFloatEnabled: false,
    toolbars: [
        ['fullscreen', 'source', 'undo', 'redo'],
        ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
    ]
});
