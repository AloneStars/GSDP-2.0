/**
 * Created by ViolentStone on 2016/11/29.
 */

var notice = {

    "url" :{
        "noticeUrl" : function(){
            return "/gsdp/notice/creation";
        }
    },

    //显示发布通知模态框
    "showPublishNotice" : function () {
        dialog.showDialog(parseInt($(".publish-notice-size").css("min-height")),
            $(".publish-notice-size").outerWidth(), "publish-notice-dialog");
    },
    
    "checkMessage" : function(message){

        message = trimBr(message);

        if(message.length==0){
            alert("通知内容不能为空");
            return false;
        }else if(message.length>=200){
            alert("通知内容不能超过200字");
            return false;
        }else{
            return true;
        }
    },
    
    "clickNotice" : function(groupId,noticeContent){
        $.ajax({
            type: "post",
            url : notice.url.noticeUrl(),
            dateType : "json",
            data:{
                "groupId" : groupId,
                "noticeContent" : noticeContent
            },
            success:function(msg){
                var json = eval(msg);
                alert(json.message);
                setTimeout(function(){
                    window.location.reload();
                },200);
            },
            error: function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
        });
    },
    
}

$(function(){
    
    $("#notice-submit").on("click",function () {
        
        var message = $("#notice-content").val();
        var groupId = $("#groupId").html();

        if(notice.checkMessage(message)){
            notice.clickNotice(groupId,message);
        }

    });

});
