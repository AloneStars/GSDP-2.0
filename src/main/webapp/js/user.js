/**
 * Created by yizijun on 2016/11/10 0010.
 */
var user = {

    /*
    与用户控制器调用的url
     */
    "url" : {

        "changeHead" : function () {
            return "/GSDP/user/changeHead";
        },

        "randomChangeHead" : function () {
            return "/GSDP/user/randomChangeHead";
        }
    },

    //与用户前端的所有验证有关
    "check" : {
        "checkPassword" : function (password) {
            //限制用户输入的密码长度为[6,16]，只能为字母，数字，和其它符号，但是不能为空白字符
            var regex = /^[a-zA-Z0-9\.@#\$%\^&\*\(\)\[\]\?\\/\|~`\+-_=,:'"]{6,16}$/;
            if(password && regex.test(password)) {
                return true;
            } else {
                return false;
            }
        },

        "isSamePassword" : function (password, confirmPassword) {
            if(password === confirmPassword) {
                return true;
            } else {
                return false;
            }
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

    //随机改变头像
    $("div.change_picture").on("click", function () {
        user.randomChangeHead();
    });

    //完成导航栏和内容的对应关系
    $("ul.nav_ul li").on("click",function(){
        var $allLi = $("ul.nav_ul > li");
        //index:搜索匹配的元素，并返回相应元素的索引值，从0开始计数。
        var index = $allLi.index(this);
        $(this).children().css("color","red");
        $("ul.nav_ul > li:not(:eq(" + index + ")) a").css("color","black");
        var func = function() {
            $(".navigation_content div[id$='_content']:not(:eq(" + index + "))").css("display", "none");
            $(".navigation_content div[id$='_content']:eq(" + index + ")").css("display", "block");
        }
        setTimeout(func,500);
    });

    $(".dialog").on("blur", "#old-password,#new-password", function () {
        if(user.check.checkPassword($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next().html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next().html("请输入正确的密码格式");
        }
    });

    $(".dialog").on("blur", "#confirm-password", function () {
        if(user.check.checkPassword($(this).val())) {
            if(user.check.isSamePassword($(this).val(), $("#new-password").val())) {
                $(this).parent().removeClass("has-error").addClass("has-success");
                $(this).next().html("");
            } else {
                $(this).parent().removeClass("has-success").addClass("has-error");
                $(this).next().html("两次输入密码不一致");
            }
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next().html("请输入正确的密码格式");
        }
    });



});