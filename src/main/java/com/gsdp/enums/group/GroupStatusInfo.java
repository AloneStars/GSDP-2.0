package com.gsdp.enums.group;

/**
 * Created by yizijun on 2016/11/5 0005.
 */
public enum  GroupStatusInfo {

    CREATE_GROUP_SUCCESS(1, "申请团队成功"),
    GROUP_REPEAT(-1, "团队已存在"),
    CREATE_GROUP_FAIL(-2, "创建团队失败")
    ;

    private int state;

    private String message;

    GroupStatusInfo(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static GroupStatusInfo getGroupStatusInfo(int state) {
        for (GroupStatusInfo groupStatusInfo : values()) {
            if(groupStatusInfo.getState() == state) {
                return groupStatusInfo;
            }
        }
        return null;
    }
}
