package com.gsdp.enums;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public enum BaseStatusInfo {

    SERVER_INTERNAL_ERROR(-1, "服务器内部错误"),
    PARAMETER_ERROR(-2, "参数错误"),;

    private int state;

    private String message;

    private BaseStatusInfo(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static BaseStatusInfo getBaseStatusInfo(int state) {
        for(BaseStatusInfo baseStatusInfo : values()) {
            if(state == baseStatusInfo.getState()) {
                return baseStatusInfo;
            }
        }
        return null;
    }
}
