package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public class GroupException extends RuntimeException {

    public GroupException(String s) {
        super(s);
    }

    public GroupException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
