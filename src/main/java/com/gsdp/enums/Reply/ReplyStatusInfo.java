package com.gsdp.enums.Reply;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/28 创造的作品
 * ********************************************************
 * +描述:回复相关的枚举类
 *********************************************************/
public enum  ReplyStatusInfo {

    REPLY_NOT_LOGIN(1,"用户尚未登录请先登录"),
    REPLY_CREATE_FAILURE(2,"评论失败"),
    REPLY_CREATE_SUCCESS(3,"评论成功")
    ;

    private int status;

    private String message;

    ReplyStatusInfo(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static ReplyStatusInfo getReplyStatusInfo(int status){
        for (ReplyStatusInfo replyStatusInfo: values()) {
            if(replyStatusInfo.getStatus() == status)
                return replyStatusInfo;
        }
        return null;
    }
}
