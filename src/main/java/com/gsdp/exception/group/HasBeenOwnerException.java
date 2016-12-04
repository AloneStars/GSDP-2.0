package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/12/4 0004.
 */
public class HasBeenOwnerException extends GroupException {

    public HasBeenOwnerException(String s) {
        super(s);
    }

    public HasBeenOwnerException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
