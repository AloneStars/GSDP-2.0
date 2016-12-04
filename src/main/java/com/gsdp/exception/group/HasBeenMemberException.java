package com.gsdp.exception.group;

/**
 * 已经是团队成员的异常类
 * Created by yizijun on 2016/12/4 0004.
 */
public class HasBeenMemberException extends GroupException {

    public HasBeenMemberException(String s) {
        super(s);
    }

    public HasBeenMemberException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
