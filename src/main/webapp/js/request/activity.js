/**
 * Created by ViolentStone on 2016/11/16.
 * 活动相关的js请求控制
 */

var activity = {

    "url" :{
        //获取发布用户连接
        "activityCreation"  : function() {
            return "/gsdp/activity/activityCreation";
        }
    },

    "checkNull" : function(activityName){

        if(Trim(activityName,"g") == "" ||isUndefine(activityName))
            return false;
        else
            return true;
    },

    "checkNumber" : function (activityNumber) {

        if(Trim(activityNumber,"g") == "")
            return false;
        else{

            var number = Number(activityNumber);

            if(!isNaN(number))
            {
                if(parseInt(number) == number)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }

    },

    "checkDate" : function(startTime,endTime){

        if(stringToDate(endTime) < stringToDate(startTime))
            return false;
        else
            return true;
    },

    "clickActivity" : function () {
        dialog.showDialog($(".modal-content").outerHeight(), $(".modal-content").outerWidth());
    },

    "activityCreation" : function() {

        var activityName = $("#activity-name").val();
        var open = $("#open").val();
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();
        var activityNumber = $("#activity-member").val();
        var location = $("#location").val();
        var content = editor.getContent();

    },
}

$(function(){

    $("#next-step").on("click",function(){

        var activityName = $("#activity-name").val();
        var activityMember = $("#activity-member").val();
        var location = $("#location").val();
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();

        if(!activity.checkNull(activityName))
            $("#activity-name").next(".err-info").html("活动名称不能为空");
        else if(!activity.checkDate(startTime,endTime))
            $("#end-time").next(".err-info").html("活动结束日期不能比开始日期早");
        else if(!activity.checkNumber(activityMember))
            $("#activity-member").next(".err-info").html("活动人数不能为空，也必须为整数");
        else if(!activity.checkNull(location))
            $("#location").next(".err-info").html("活动地点不能为空");
        else{
            $("#activity-name").next(".err-info").html("");
            $("#activity-member").next(".err-info").html("");
            $("#location").next(".err-info").html("");
            $("#end-time").next(".err-info").html("");

            setTimeout(function () {
                $(".modal-body>div:lt(3)").css("display" , "none");
                $(".create-activity-size").css("height", 600);
                $(".modal-body").css("padding", "0");
                $(".modal-footer button:lt(2)").css("display", "none");
                $(".modal-footer button:gt(1)").css("display", "inline-block");
                dialog.reModify($(".modal-content").outerHeight(), $(".modal-content").outerWidth());
                $(".modal-body>div:eq(3)").css("display", "block");
            },100);

        }

    });

    $("#last-step").on("click", function () {
        /*
         还原当前dialog到基本信息页
         1.隐藏当前div
         2.还原按钮
         3.还原高度
         4.重写调整弹出框位置
         5.显示基本信息div
         */
        $(".modal-body>div:eq(3)").css("display", "none");
        $(".modal-footer button:lt(2)").css("display", "inline-block");
        $(".modal-footer button:gt(1)").css("display", "none");
        $(".create-activity-size").css("height", 300);
        $(".modal-body").removeAttr("style");
        dialog.reModify($(".modal-content").outerHeight(), $(".modal-content").outerWidth());
        $(".modal-body>div:lt(3)").css("display","block");
        dialog.showDialog($(".modal-content").outerHeight(), $(".modal-content").outerWidth());
    });

});
