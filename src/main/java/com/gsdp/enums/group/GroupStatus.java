package com.gsdp.enums.group;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public enum GroupStatus {

    CLOSE(-1, "已关闭"),
    APPLYING(0, "申请中"),
    RUNNING(1, "运行中");

    private int state;

    private String stateInfo;

    GroupStatus(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static GroupStatus getGroupStatus(int state) {
            for(GroupStatus groupStatus : values()) {
                if(groupStatus.getState() == state) {
                    return groupStatus;
                }
            }
            return null;
    }
}
