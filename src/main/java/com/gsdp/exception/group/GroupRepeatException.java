package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/11/3 0003.
 */
public class GroupRepeatException extends GroupException {

    public GroupRepeatException(String s) {
        super(s);
    }

    public GroupRepeatException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
