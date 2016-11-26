/**
 * 用户登录和注册相关的js控制
 * Created by ViolentStone on 2016/11/21.
 */

var login = {

    "url" : {
        "loginUrl" : function(){
            return "/gsdp/user/login";
        }
    },

    "checkEmail" : function(email){
        if(checkMail(email))
            return true;
        else
            return false;
    },

    "checkPassword" : function (password) {

        return user.check.checkPassword(password);

    },

    "clickLogin" : function(email,password){

        if(login.checkEmail(email)){
            $("#login-email").next(".err-info").html("");
        }else{
            $("#login-email").next(".err-info").html("邮箱格式不正确");
            return false;
        }

        if(login.checkPassword(password)){
            $("#login-password").next(".err-info").html("");
        }else{
            $("#login-password").next(".err-info").html("密码格式不正确，可能包含中文或者空格的等字符");
            return false;
        }

        return true;

    },

    "login" : function(email,password){

        $.ajax({
            type: "post",
            url : login.url.loginUrl(),
            dateType : "json",
            data:{
                "email" : email,
                "password" : password
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

    //显示登录模态框
    "showLoginDialog" : function () {
        dialog.showDialog(parseInt($(".login-register-dialog-size").css("min-height")),
            $(".login-register-dialog-size").outerWidth(), "login-register-dialog");
    },

};

var register = {

    "url" :{
        "registerUrl" : function(){
            return "/gsdp/user/register";
        },
        "sendVerifyCode":function(){
            return "/gsdp/user/sendVerifyCode";
        }
    },

    "checkPassword" : function (password) {

        return user.check.checkPassword(password);

    },

    "confirmPassword" : function(password,confirmPassword){
        return user.check.isSamePassword(password,confirmPassword);
    },

    "verifyCode" : function(verifyCode){
       return verifyNumber(verifyCode,6);
    },

    "clickRegister" : function(email,password,confirmPassword,verifyCode){

        if(login.checkEmail(email)){
            $("#register-email").next(".err-info").html("");
        }else{
            $("#register-email").next(".err-info").html("邮箱格式不正确");
            return false;
        }

        if(register.checkPassword(password)){
            $("#register-password").next(".err-info").html("");
        }else{
            $("#register-password").next(".err-info").html("请确认密码输入正确,不能包含中文或者空格的等字符");
            return false;
        }

        if(register.confirmPassword(password,confirmPassword)){
            $("#register-confirm-password").next(".err-info").html("");
        }else{
            $("#register-confirm-password").next(".err-info").html("请确认密码，两次输入的密码要一样");
            return false;
        }

        if(register.verifyCode(verifyCode,6)){
            $("#captcher").next(".err-info").html("");
        }
        else{
            $("#captcher").next(".err-info").html("请输入验证码，验证码应为6位纯数字");
            return false;
        }

        return true;

    },

    "clickSendVerifyCode":function(email){

        $.ajax({
            type:"post",
            url:register.url.sendVerifyCode(),
            dateType:"json",
            data:{
                "email":email
            },
            success:function(msg){
                //这里使用JSON.parse始终解析不到相应的数据
                var json = eval(msg);
                alert(json.message);
            },
            error:function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
        });

    },

    "register" : function(email,password,confirmPassword,verifyCode){

        $.ajax({
            type: "post",
            url:register.url.registerUrl(),
            dateType:"json",
            data:{
                "email":email,
                "password":password,
                "confirmPassword":confirmPassword,
                "verifyCode":verifyCode
            },
            success:function(msg){
                //这里使用JSON.parse始终解析不到相应的数据
                var json = eval(msg);
                 alert(json.message);
            },
            error:function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
        });
    }
}


var logout ={

    "url" : {
        "logoutUrl" : function(){
            return "/gsdp/user/logout";
        }
    },

    "logout":function(){
        $.ajax({
            type: "post",
            url : logout.url.logoutUrl(),
            dateType : "json",
            success:function(msg){
                var json = eval(msg);
                alert(json.message);
                window.location.reload();
            },
            error: function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
        });
    }
}

$(function(){

//保证登录和注册切换的时候dialog是放在中间的
    $("#login-register-modal li:eq(0)").on("click", function () {
        $(".login-register-dialog-size").css("min-height",240);
        $("#login-register-dialog").css("min-height",240);
        dialog.reModify(parseInt($(".login-register-dialog-size").css("min-height")),
            $(".login-register-dialog-size").outerWidth());
    });

    $("#login-register-modal li:eq(1)").on("click", function () {
        $(".login-register-dialog-size").css("min-height",340);
        $("#login-register-dialog").css("min-height",340);
        dialog.reModify(parseInt($(".login-register-dialog-size").css("min-height")),
            $(".login-register-dialog-size").outerWidth());
    });

    $("#login").on("click",function(){

        var email = $("#login-email").val();
        var password = $("#login-password").val();

        if(login.clickLogin(email,password)){
            login.login(email,password);
        }

    });

    $("#register").on("click",function(){

        var email = $("#register-email").val();
        var password = $("#register-password").val();
        var confirmPassword = $("#register-confirm-password").val();
        var verifyCode = $("#captcher").val();

        if(register.clickRegister(email,password,confirmPassword,verifyCode)){
            register.register(email,password,confirmPassword,verifyCode);
        }

    });

    $("#sendVerifyCode").on("click",function(){

        var email = $("#register-email").val();

        if(login.checkEmail(email)){
            $("#register-email").next(".err-info").html("");
            register.clickSendVerifyCode(email);
        }else{
            $("#register-email").next(".err-info").html("邮箱格式不正确");
        }
    })

});
