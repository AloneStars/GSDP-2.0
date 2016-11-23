package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public class NotInGroupException extends GroupException {

    public NotInGroupException(String s) {
        super(s);
    }

    public NotInGroupException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
