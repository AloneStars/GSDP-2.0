package com.gsdp.enums.user;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/22 创造的作品
 * ********************************************************
 * +描述:
 *********************************************************/
public enum UserStatusInfo {

    USER_LOGIN_SUCCESS(0,"用户登录成功"),
    USER_UNDEFINED(1,"用户不存在"),
    USER_LOGIN_MESSAGE_INCORRECT(2,"用户名或者密码错误"),
    USER_LOGOUT_SUCCESS(4,"用户注销成功"),
    USER_LOGOUT_FAILURE(5,"用户注销失败"),
    USER_REGISTER_USEREXISTED(6,"该邮箱已被注册"),
    USER_REGISTER_CONFIRMPASSWORDFAILURE(7,"注册密码验证失败"),
    USER_REGISTER_VERIFTCORRECT(8,"验证码不正确"),
    USER_REGISTER_SUCCESS(9,"用户注册成功"),
    USER_REGISTER_FAILURE(10,"用户注册失败"),
    USER_SENDVERIFYCODE_SUCCESS(11,"验证码发送成功")
    ;

    private int status;

    private String message;

    UserStatusInfo(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static  UserStatusInfo getUserStatusInfo(int status){
        for (UserStatusInfo userStausInfo: values()) {
            if(userStausInfo.getStatus() == status)
                return userStausInfo;
        }
        return null;
    }

}
