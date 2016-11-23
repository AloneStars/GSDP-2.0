package com.gsdp.enums.user;

/**
 * Created by yizijun on 2016/11/22 0022.
 */
public enum  UserStatusInfo {

    MODIFY_PASSWORD_SUCCESS(1, "密码修改成功"),
    MODIFY_HEAD_PICTURE_SUCCESS(2, "头像修改成功"),
    ORIGINAL_PASSWORD_ERROR(-1, "原密码错误"),
    TWO_PASSWORD_INPUT_NOT_MATCH(-2, "两次输入密码不匹配"),
    MODIFY_PASSWORD_FAIL(-3, "密码修改失败"),
    MAIL_ALREADY_EXIST(-4, "邮箱已存在"),
    MODIFY_HEAD_PICTURE_FAIL(-5, "头像修改失败"),
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

    private int state;

    private String message;

    private UserStatusInfo(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;


    public static UserStatusInfo getUserStatusInfo(int state) {
        for (UserStatusInfo userStatusInfo : values()) {
            if(userStatusInfo.getState() == state) {
                return userStatusInfo;
            }
        }
        return null;
    }

}
