package com.gsdp.exception.group;

/**
 * 不是社团管理员的异常
 * Created by yizijun on 2016/12/1 0001.
 */
public class NotGroupAdminException extends GroupException {

    public NotGroupAdminException(String s) {
        super(s);
    }

    public NotGroupAdminException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
