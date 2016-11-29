/**
 * Created by ViolentStone on 2016/11/29.
 */

var notice = {

    url:{
        "noticeUrl" : function(){

        }
    },

    //显示发布通知模态框
    "showPublishNotice" : function () {
        dialog.showDialog(parseInt($(".publish-notice-size").css("min-height")),
            $(".publish-notice-size").outerWidth(), "publish-notice-dialog");
    }
    
}

$(function(){

});
