package com.gsdp.enums.Ntoice;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/29 创造的作品
 * ********************************************************
 * +描述:动态相关的枚举类
 *********************************************************/
public enum  NoticeStatusInfo {

    NOTICE_CREATE_SUCCESS(1,"通知发布成功"),
    NOTICE_CREATE_FAILURE(2,"通知发布失败"),
    NOTICE_MESSAGESIZE_INCORRECT(3,"通知内容的长度不符合标准")
    ;

    private int status;

    private String message;

    NoticeStatusInfo(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static NoticeStatusInfo getNoticeStatusInfo(int status){
        for (NoticeStatusInfo noticeStatusInfo: values()) {
            if(noticeStatusInfo.getStatus() == status)
                return noticeStatusInfo;
        }
        return null;
    }

}