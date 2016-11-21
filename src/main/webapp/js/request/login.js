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

};

var register = {

    "url" :{
        "registerUrl" : function(){
            return "gsdp/user/register";
        }
    },
    
    "checkPassword" : function(onePassword,SecondPassword){
        
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

});
