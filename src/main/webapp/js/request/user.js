/**
 * Created by yizijun on 2016/11/10 0010.
 */
var user = {
    /*
    与用户控制器调用的url
     */
    "url" : {

        "modifyPassword" : function () {
            return "/gsdp/user/modifyPassword";
        },

        "changeHead" : function () {
            return "/gsdp/user/changeHead";
        },

        "randomChangeHead" : function () {
            return "/gsdp/user/randomChangeHead";
        },
        
        "modifyUserBaseInfo" : function () {
            return "/gsdp/user/modifyBaseInfo";
        },

        "applyJoinGroup" : function () {
            return "/gsdp/user/applyJoinGroup";
        }
    },

    //与用户前端的所有验证有关
    "check" : {

        "checkUsername" : function (username) {
            //用户名的长度在[1,15]之间，并且不能有空格和特殊字符，只能为中文，大小写字母和数字
            var regex = /^[a-zA-z0-9\u4E00-\u9FA5]{1,15}$/;
            if(username && regex.test(username)) {
                return true;
            } else {
                return false;
            }
        },

        "checkPassword" : function (password) {
            //限制用户输入的密码长度为[6,16]，只能为字母，数字，和其它符号，但是不能为空白字符
            var regex = /^[a-zA-Z0-9\.@#\$%\^&\*\(\)\[\]\?\\/\|~`\+-_=,:'"]{6,16}$/;
            if(password && regex.test(password)) {
                return true;
            } else {
                return false;
            }
        },

        "checkPhone" : function (phone) {
          return group.check.checkGroupContact(phone);
        },

        "checkApplyJoinGroupReason" : function (applyReason) {
            //验证用户输入的申请加入团队信息只能为[10,100]之间，并且不能有空格
            var regex = /^\S{10,100}$/;
            if(applyReason && regex.test(applyReason)) {
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
        },
        
        "checkAge" : function (age) {
            //为[1,9]位的正整数,下面这个正则可以匹配0000这种形式
            var regex = /^\d{1,9}$/;
            if(age && regex.test(age)) {
                return true;
            } else {
                return false;
            }
        },

        "checkWechat" : function (wechat) {
          //这里只是做了一个简单的验证空的操作
            if(wechat && Trim(wechat,"g").length > 0) {
                return true;
            } else {
                return false;
            }
        },

        "checkPersonIntroduce" : function (personIntroduce) {
            //用户输入的个人介绍字数在[5,100]之间，并且不能有空白符
            var regex = /^\S{5,100}$/;
            if(personIntroduce && regex.test(personIntroduce)) {
                return true;
            } else {
                return false;
            }
        }
    },
    
    "randomChangeHead" : function () {
        $.get(user.url.randomChangeHead(), function (data) {
            if(data.success) {
                $(".modify_headPicture > img").attr("src","/gsdp/" + data.data);
            } else {
             alert(data.message);
            }
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
                dataType : "json",
                success : function(data) {
                    if(data.success) {
                        $(".modify_headPicture > img").attr("src","/gsdp/" + data.data);
                    } else {
                        alert(data.message);
                    }
                }
            });
        }
    },

    "modifyPassword" : function () {
        var oldPassword = $("#old-password").val();
        var newPassword = $("#new-password").val();
        var confirmPassword = $("#modify-confirm-password").val();

        if(user.check.checkPassword(oldPassword) && user.check.checkPassword(newPassword) &&
            user.check.checkPassword(confirmPassword) && user.check.isSamePassword(newPassword,
            confirmPassword)) {

            $.post(user.url.modifyPassword(),
                {
                    "oldPassword" : oldPassword,
                    "newPassword" : newPassword,
                    "confirmPassword" : confirmPassword
                } , function (data) {
                    alert(data.message);
                }
            )
        }
    },

    "modifyUserBaseInfo" : function () {
        var username = $(".modify_basic_info #username").val();
        var age = $(".modify_basic_info #age").val();
        var sex = $(".modify_basic_info input[name='gender']:checked").val();
        var weChat = $(".modify_basic_info #wechat").val();
        var userDec = $(".modify_basic_info #person-introduce").val();

        if(user.check.checkUsername(username) && user.check.checkAge(age) &&
        user.check.checkWechat(weChat) && user.check.checkPersonIntroduce(userDec)) {
            $.post(user.url.modifyUserBaseInfo(),
                {
                    "username" : username,
                    "age" : age,
                    "sex" : sex,
                    "weChat" : weChat,
                    "userDec" : userDec
                }, function (data) {
                    if(data.success) {
                        location.reload();
                    } else {
                        alert(data.message);
                    }
                });
        }
    },

    "applyJoinGroup" : function () {
        var phone = $("#apply-join-group-contact").val();
        var applyReason = $("#apply-reason").val();
        var groupId = $("#groupId").text();

        if(user.check.checkPhone(phone) && user.check.checkApplyJoinGroupReason(applyReason)) {
            $.post(user.url.applyJoinGroup(),
                {
                    "groupId" : groupId,
                    "applyReason" : applyReason,
                    "phone" : phone
                }, function (data) {
                    alert(data.message);
                });
        }
    },

    //显示修改密码模态框
    "showModifyPasswordDialog" : function () {
        dialog.showDialog(parseInt($(".modify-password-size").css("min-height")),
        $(".modify-password-size").outerWidth(), "modify-password-dialog");
    },

    //关闭修改密码模态框
    "closeModifyPasswordDialog" : function () {
        $("#modify-password-form div").removeClass("has-error has-success");
        $("div.err-info").html("");
        $("#modify-password-form")[0].reset();
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

    //完成修改密码按钮的事件绑定
    $("#modify-password-button").on("click", function () {
        user.modifyPassword();
    });

    $("#confirm-modify-baseInfo").on("click", function () {
        user.modifyUserBaseInfo();
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
        setTimeout(func,100);
    });

    $(".dialog").on("blur", "#old-password,#new-password", function () {
        if(user.check.checkPassword($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next(".err-info").html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next(".err-info").html("请输入正确的密码格式");
        }
    });

    $(".dialog").on("blur", "#modify-confirm-password", function () {
        if(user.check.checkPassword($(this).val())) {
            if(user.check.isSamePassword($(this).val(), $("#new-password").val())) {
                $(this).parent().removeClass("has-error").addClass("has-success");
                $(this).next(".err-info").html("");
            } else {
                $(this).parent().removeClass("has-success").addClass("has-error");
                $(this).next(".err-info").html("两次输入密码不一致");
            }
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next(".err-info").html("请输入正确的密码格式");
        }
    });
    
    $(".modify_basic_info #username").on("blur", function () {
        if(user.check.checkUsername($(this).val())) {
            $(this).next(".err-info").html("");
        } else {
            $(this).next(".err-info").html("请输入正确的用户名格式");
        }
    });

    $(".modify_basic_info #age").on("blur", function () {
        if(user.check.checkAge($(this).val())) {
            $(this).next(".err-info").html("");
        } else {
            $(this).next(".err-info").html("请输入正确的年龄格式");
        }
    });

    $(".modify_basic_info #wechat").on("blur", function () {
        if(user.check.checkWechat($(this).val())) {
            $(this).next(".err-info").html("");
        } else {
            $(this).next(".err-info").html("请输入正确的微信格式");
        }
    });

    $(".modify_basic_info #person-introduce").on("blur", function () {
        if(user.check.checkPersonIntroduce($(this).val())) {
            $(this).next(".err-info").html("");
        } else {
            $(this).next(".err-info").html("请输入正确的个人介绍格式");
        }
    });

    $("#join-group-form #apply-join-group-contact").on("blur", function () {
       if(user.check.checkPhone($(this).val())) {
           $(this).parent().removeClass("has-error").addClass("has-success");
           $(this).next(".err-info").html("");
       } else {
           $(this).parent().removeClass("has-success").addClass("has-error");
           $(this).next(".err-info").html("手机号码格式输入错误");
       }
    });

    $("#join-group-form #apply-reason").on("blur", function () {
        if(user.check.checkApplyJoinGroupReason($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next(".err-info").html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next(".err-info").html("申请理由格式错误");
        }
    })
});