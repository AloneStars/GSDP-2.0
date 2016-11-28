/**
 * Created by ViolentStone on 2016/11/28.
 */

var reply = {

    "url" :{
        "replyUrl" : function(){
            return "/gsdp/reply/creation";
        }
    },

    "checkMessage" : function(message){

        if(message.length==0){
            alert("评论内容不能为空");
            return false;
        }else if(message.length>=50){
            alert("评论内容不能超过50字");
            return false;
        }else{
            return true;
        }

    },

    "clickReply" : function(situationId,replyContent){

        $.ajax({
            type: "post",
            url : reply.url.replyUrl(),
            dateType : "json",
            data:{
                "situationId" : situationId,
                "replyContent" : replyContent
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
    }
}

$(function(){
    $("#reply").on("click",function () {

        var message = $("#replyMessage").val();
        var situationId = $("#situationId").html();

        if(reply.checkMessage(message)){
            reply.clickReply(situationId,message);
        }

    });
});
