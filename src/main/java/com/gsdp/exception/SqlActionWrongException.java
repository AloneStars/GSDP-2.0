package com.gsdp.exception;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/1 创造的作品
 * ********************************************************
 * +描述:数据库操作异常类
 *********************************************************/
public class SqlActionWrongException extends Exception {

    public SqlActionWrongException(String msg) {
        super(msg);
    }
}