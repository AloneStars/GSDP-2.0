package com.gsdp.enums.situation;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public enum  SituationStatusInfo {

    PUBLISH_SITUATION_SUCCESS(1, "发布动态成功"),
    PUBLISH_SITUATION_FAIL(-1, "发布动态失败"),
    ;

    private int state;

    private String message;

    private SituationStatusInfo(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static SituationStatusInfo getSituationStatusInfo(int state) {
        for(SituationStatusInfo situationStatusInfo : values()) {
            if(state == situationStatusInfo.getState()) {
                return situationStatusInfo;
            }
        }
        return null;
    }
}
