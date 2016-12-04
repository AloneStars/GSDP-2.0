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

    ORIGINAL_PASSWORD_ERROR(-1, "原密码错误"),
    TWO_PASSWORD_INPUT_NOT_MATCH(-2, "两次输入密码不匹配"),
    MODIFY_PASSWORD_FAIL(-3, "密码修改失败"),
    MODIFY_HEAD_PICTURE_FAIL(-4, "头像修改失败"),
    MODIFY_USER_BASE_INFO_FAIL(-5, "用户基本信息修改失败"),
    USER_LOGIN_SUCCESS(0,"用户登录成功"),
    USER_UNDEFINED(1,"用户不存在"),
    USER_LOGIN_MESSAGE_INCORRECT(2,"用户名或者密码错误"),
    MODIFY_USER_BASE_INFO_SUCCESS(3, "用户基本信息修改成功"),
    USER_LOGOUT_SUCCESS(4,"用户注销成功"),
    USER_LOGOUT_FAILURE(5,"用户注销失败"),
    USER_REGISTER_USEREXISTED(6,"该邮箱已被注册"),
    USER_REGISTER_CONFIRMPASSWORDFAILURE(7,"注册密码验证失败"),
    USER_REGISTER_VERIFTCORRECT(8,"验证码不正确"),
    USER_REGISTER_SUCCESS(9,"用户注册成功"),
    USER_REGISTER_FAILURE(10,"用户注册失败"),
    USER_SENDVERIFYCODE_SUCCESS(11,"验证码发送成功"),
    MODIFY_PASSWORD_SUCCESS(12, "密码修改成功"),
    MODIFY_HEAD_PICTURE_SUCCESS(13, "头像修改成功"),
    USER_SENDVERIFYCODE_FAILURE(14,"验证码发送失败,请检查邮箱"),
    USER_NOT_LOGIN(15,"用户尚未登录，请先登录")
    ;

    private int state;

    private String message;

    private UserStatusInfo(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static UserStatusInfo getUserStatusInfo(int state) {
        for (UserStatusInfo userStatusInfo : values()) {
            if(userStatusInfo.getState() == state) {
                return userStatusInfo;
            }
        }
        return null;
    }

}
