/**
 * Created by ViolentStone on 2016/11/16.
 * 活动相关的js请求控制
 */

var activity = {

    "url" :{
        //获取发布用户连接
        "activityCreation"  : function() {
            return "/gsdp/activity/creation";
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
        dialog.showDialog(parseInt($(".create-activity-size").css("min-height")),
            $(".create-activity-size").outerWidth(), "create-activity-dialog");
    },

    "checkNestStep" : function(activityName,activityMember,location,startTime,endTime){

        if(!activity.checkNull(activityName)){
            $("#activity-name").next(".err-info").html("活动名称不能为空");
            return false;
        }
        else
            $("#activity-name").next(".err-info").html("");

        if(startTime == ""){
            $("#start-time").next(".err-info").html("请选择活动起始时间");
            return false;
        }
        else
            $("#start-time").next(".err-info").html("");

        if(endTime == ""){
            $("#end-time").next(".err-info").html("请选择活动结束时间");
            return false;
        }
        else
            $("#end-time").next(".err-info").html("");

        
        if(!activity.checkDate(startTime,endTime)){
            $("#end-time").next(".err-info").html("活动结束日期不能比开始日期早");
            return false;
        }
        else
            $("#end-time").next(".err-info").html("");

        if(!activity.checkNumber(activityMember)){
            $("#activity-member").next(".err-info").html("活动人数不能为空，也必须为整数");
            return false;
        }
        else
            $("#activity-member").next(".err-info").html("");

        if(!activity.checkNull(location)){
            $("#location").next(".err-info").html("活动地点不能为空");
            return false;
        }
        else
            $("#location").next(".err-info").html("");


        return true;
    },

    "activityCreation" : function() {

        var activityName = $("#activity-name").val();
        var open = $("#open").val();
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();
        var activityNumber = $("#activity-member").val();
        var location = $("#location").val();
        var content = editor.getContent();

        $.ajax({
            type:"post",
            url: activity.url.activityCreation(),
            dataType:"json",
            data:{
                "activityName" : activityName,
                "open" : open,
                "startTime" : startTime,
                "endTime" : endTime,
                "activityNumber" : activityNumber,
                "location" : location,
                "content" : content
            },
            success:function(msg){
                //这里使用JSON.parse始终解析不到相应的数据
                var json = eval(msg);
                alert(json.context);
            },
            error:function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
        });

    },
}

$(function(){

    $("#next-step").on("click",function(){

        var activityName = $("#activity-name").val();
        var activityMember = $("#activity-member").val();
        var location = $("#location").val();
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();

        if(activity.checkNestStep(activityName,activityMember,location,startTime,endTime)){
            setTimeout(function () {
                /*
                 1.隐藏所有的基本信息输入框
                 2.调整modal-content的高度
                 3.改变一些基本的样式
                 4.隐藏和显示modal-footer的一些图标
                 */
                $(".create-activity-size .modal-body > div:lt(3)").css("display" , "none");
                $(".create-activity-size").css("min-height", 600);
                $(".create-activity-size .modal-body").css("padding", "0");
                $(".create-activity-size .modal-footer button:lt(2)").css("display", "none");
                $(".create-activity-size .modal-footer button:gt(1)").css("display", "inline-block");
                dialog.reModify(parseInt($(".create-activity-size").css("min-height")),
                    $(".create-activity-size").outerWidth());
                $(".create-activity-size .modal-body>div:eq(3)").css("display", "block");
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
        $(".create-activity-size .modal-body > div:eq(3)").css("display", "none");
        $(".create-activity-size .modal-footer button:lt(2)").css("display", "inline-block");
        $(".create-activity-size .modal-footer button:gt(1)").css("display", "none");
        $(".create-activity-size").css("min-height", 300);
        $(".create-activity-size .modal-body").removeAttr("style");
        dialog.reModify(parseInt($(".create-activity-size").css("min-height")), $(".create-activity-size").outerWidth());
        $(".create-activity-size .modal-body>div:lt(3)").css("display","block");
    });

    $("#submit").on("click",function(){
        activity.activityCreation();
    });

});
