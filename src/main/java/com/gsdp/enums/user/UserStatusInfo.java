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
