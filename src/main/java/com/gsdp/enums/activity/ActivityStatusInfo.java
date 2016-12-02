package com.gsdp.enums.activity;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/30 创造的作品
 * ********************************************************
 * +描述:活动相关的枚举类
 *********************************************************/
public enum  ActivityStatusInfo {

    ACTIVITY_CREATE_SUCCESS(1,"活动发布成功"),
    ACTIVITY_CREATE_FAILURE(2,"活动发布失败"),
    ACTIVITY_TIME_INCORRECT(3,"活动时间异常"),
    ACTIVITY_PERMISSION_INCORRECT(4,"活动开发权限异常")
    ;

    private int status;

    private String message;

    ActivityStatusInfo(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static ActivityStatusInfo getActivityStatusInfo(int status){
        for (ActivityStatusInfo activityStatusInfo: values()) {
            if(activityStatusInfo.getStatus() == status)
                return activityStatusInfo;
        }
        return null;
    }
}
