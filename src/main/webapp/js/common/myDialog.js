/**
 * Created by yizijun on 2016/10/21 0021.
 */
var dialog = {

    getScrollHeight : function () {
        var scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
        return scrollHeight;
    },

    /*
    这是关闭dialog，但是注意的是我们这里直接把其empty掉了，说明这段html代码我们是直接
    写在js里面的。
     */
    closeDialogWithJs : function() {
        dialog.closeDialog();
        $("div.dialog").empty();
    },

    /*
    这段关闭dialog的代码是将我们的dialog直接写在html文件中。
     */
    closeDialog : function() {
        $("div.hideBack").hide();
        // $("div.dialog").hide("slow");
        $("div.dialog").hide();
    },

    /*
    显示隐藏面
     */
    showHideBack : function() {
        var scrollHeight = dialog.getScrollHeight();
        var $hideBack = $("div.hideBack");
        $hideBack.css("height",scrollHeight);
        $hideBack.show();
    },

    /*
    显示在html文件中定义的dialog
     */
    showDialog : function (height, width) {
        dialog.showHideBack();
        dialog.setDialogWidthAndHeight(width, height);
        dialog.changeDialogPosition(height, width);
         $("div.dialog").fadeIn("slow");
    },

    /*
    设置dialog的宽度和高度，用px来表示，注意高度不要超过实际屏幕的高度，因为这里
    我还没有对这种方式进行处理。
     */
    setDialogWidthAndHeight : function(width, height) {
        $("div.dialog").css({"min-height" : height, "width" : width});
    },

    /*
    动态的改变dialog的位置。
     */
    changeDialogPosition: function(height, width) {
        var $dialog = $("div.dialog");
        var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
        var clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
        console.log("clientHeight =" + clientHeight);
        console.log("clientWidth =" + clientWidth);
        if(clientHeight < height) {
            $dialog.css({"position" : "absolute","top" : "0px"});
        } else {
            $dialog.css({"position" : "fixed","top" : (clientHeight - height) / 2});
        }

        $dialog.css("left",(clientWidth - width) / 2);
    },

    /*
    这个方法是供当用户改变了屏幕的分辨率时，我们也动态的调整我们dialog的位置。
     */
    reModify : function(height, width) {
        var scrollHeight = dialog.getScrollHeight();
        $("div.hideBack").css("height",scrollHeight);
        dialog.changeDialogPosition(height, width);
        console.log("scrollHeight = " + scrollHeight);
    }
}
