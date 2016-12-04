package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/12/1 0001.
 */
public class HasBeenAdminException extends GroupException {

    public HasBeenAdminException(String s) {
        super(s);
    }

    public HasBeenAdminException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
