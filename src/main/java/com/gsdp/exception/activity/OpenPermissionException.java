package com.gsdp.exception.activity;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/30 创造的作品
 * ********************************************************
 * +描述:用户开发权限异常
 *********************************************************/
public class OpenPermissionException extends ActivityException{

    public OpenPermissionException(String message) {
        super(message);
    }

    public OpenPermissionException(String message, Throwable cause) {
        super(message, cause);
    }
}
