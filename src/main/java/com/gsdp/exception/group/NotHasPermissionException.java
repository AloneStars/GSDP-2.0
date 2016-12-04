package com.gsdp.exception.group;

/**
 * 主要做用户越权的异常类
 * Created by yizijun on 2016/12/4 0004.
 */
public class NotHasPermissionException extends GroupException {

    public NotHasPermissionException(String s) {
        super(s);
    }

    public NotHasPermissionException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
