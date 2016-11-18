/**
 * Created by yizijun on 2016/10/21 0021.
 */
var dialog = {

    getScrollHeight : function () {
        var scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
        return scrollHeight;
    },

    /**
     *
     */
    closeDialogWithJs : function() {
        dialog.closeDialog();
        $("div.dialog").empty();
    },


    closeDialog : function() {
        $("div.hideBack").hide();
        // $("div.dialog").hide("slow");
        $("div.dialog").hide();
    },

    /**
     *
     */
    showHideBack : function() {
        var scrollHeight = dialog.getScrollHeight();
        var $hideBack = $("div.hideBack");
        $hideBack.css("height",scrollHeight);
        $hideBack.show();
    },

    /**
     *
     * @param height
     * @param width
     * @param dialogId
     */
    showDialog : function (height, width, dialogId) {
        dialog.showHideBack();
        dialog.setDialogWidthAndHeight(width, height, dialogId);
        dialog.changeDialogPosition(height, width);
        $("div#" + dialogId).fadeIn("slow");
    },

    /**
     *
     * @param width
     * @param height
     * @param dialogId
     */
    setDialogWidthAndHeight : function(width, height, dialogId) {
        $("div#" + dialogId).css({"min-height" : height, "width" : width});
    },

    /**
     *
     * @param height
     * @param width
     */
    changeDialogPosition: function(height, width) {
        var $dialog = $("div.dialog");
        var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
        var clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
        if(clientHeight < height) {
            $dialog.css({"position" : "absolute","top" : "0px"});
        } else {
            $dialog.css({"position" : "fixed","top" : (clientHeight - height) / 2});
        }

        $dialog.css("left",(clientWidth - width) / 2);
    },

    /**
     *
     * @param height
     * @param width
     */
    reModify : function(height, width) {
        var scrollHeight = dialog.getScrollHeight();
        $("div.hideBack").css("height",scrollHeight);
        dialog.changeDialogPosition(height, width);
    }
}
