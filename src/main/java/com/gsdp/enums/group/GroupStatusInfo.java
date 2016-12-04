package com.gsdp.enums.group;

/**
 * Created by yizijun on 2016/11/5 0005.
 */
public enum  GroupStatusInfo {

    CREATE_GROUP_SUCCESS(1, "创建团队成功"),
    QUIT_GROUP_SUCCESS(2, "退出团队成功"),
    APPLICATION_HAS_BEEN_SUBMITTED(3, "您的申请已提交"),
    GET_GROUP_MESSAGE_SUCCESS(4, "获取团队信息成功"),
    GET_GROUP_APPLY_MEMBER_SUCCESS(5, "获取团队申请成员信息成功"),
    OPERATION_SUCCESS(6, "操作成功"),
    GET_GROUP_MEMBER_SUCCESS(7, "获取团队用户信息成功"),
    OWNER_CHANGE_SUCCESS(8, "法人转变成功"),
    GROUP_REPEAT(-1, "团队已存在"),
    CREATE_GROUP_FAIL(-2, "创建团队失败"),
    QUIT_GROUP_FAIL(-3, "退出团队失败"),
    NOT_IN_THE_GROUP(-4, "您不在该组织"),
    GROUP_NOT_EXIST(-5, "团队不存在"),
    APPLICATION_SUBMISSION_FAILED(-6, "您的申请提交失败"),
    GET_GROUP_APPLY_MEMBER_FAILED(-7, "获取团队申请成员信息失败"),
    OPERATION_FAIL(-8, "操作失败"),
    OWNER_CAN_NOT_QUIT_GROUP(-9, "法人无法退出团队"),
    OWNER_CHANGE_FAIL(-10, "法人转变失败"),
    HAS_BEEN_GROUP_ADMIN(-11, "你已是社团管理员"),
    IS_NOT_GROUP_ADMIN(-12, "你不是团队的管理员"),
    HAS_BEEN_GROUP_OWNER(-13, "你已是团队法人"),
    NOT_HAS_PERMISSION(-14, "你无权进行这次操作"),
    HAS_BEEN_GROUP_MEMBER(-15, "你已是团队成员")
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
