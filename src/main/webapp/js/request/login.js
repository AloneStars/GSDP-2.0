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
            return false''
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


});
