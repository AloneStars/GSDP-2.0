package com.gsdp.exception.activity;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/23 创造的作品
 * ********************************************************
 * +描述:活动相关的异常类
 *********************************************************/
public class ActivityException extends RuntimeException {

    public ActivityException(String message) {
        super(message);
    }

    public ActivityException(String message, Throwable cause) {
        super(message, cause);
    }

}
