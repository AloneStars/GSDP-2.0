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
                alert(json.context);
            },
            error: function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
            
        });
    }

};

var register = {

    "url" :{
        "registerUrl" : function(){
            return "gsdp/user/register";
        }
    },

    "checkPassword" : function (password) {

        return user.check.checkPassword(password);

    },
    
    "ConfirmPassword" : function(password,confirmPassword){
        return user.check.isSamePassword(password,confirmPassword);
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
            
        }
            
    });

});
