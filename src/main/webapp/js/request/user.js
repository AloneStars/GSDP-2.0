/**
 * Created by yizijun on 2016/11/10 0010.
 */
var user = {
    /*
    与用户控制器调用的url
     */
    "url" : {

        "changeHead" : function () {
            return "/gsdp/user/changeHead";
        },

        "randomChangeHead" : function () {
            return "/gsdp/user/randomChangeHead";
        }
    },

    "randomChangeHead" : function () {
        $.get(user.url.randomChangeHead(), function (data) {
            alert(data.data);
        },"json");
    },

    "changeHead" : function () {
        var profile = $("#profile").val();
        if(profile) {
            $.ajaxFileUpload({
                type : "post",
                url : user.url.changeHead(),
                secureuri : false,
                fileElementId : "profile",
                dataType : "JSON",
                success : function(data) {
                    alert(data);
                }
            });
        }
    }
};

$(function () {
    /*
    注意我们在运用input[type = "file"]来完成change事件的时候，
    我们要注意我们如果不采用冒泡的方式来绑定这个元素的事件的话，其
    只会绑定一次，所以我猜测input[type = "file"]这个元素是每用一次
    而动态添加进来一次。
     */
    $("div.upload_picture").on("change", "#profile", function () {
        user.changeHead();
    });


    $("div.change_picture").on("click", function () {
        user.randomChangeHead();
    });

});