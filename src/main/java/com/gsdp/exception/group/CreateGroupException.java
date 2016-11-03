package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public class CreateGroupException extends GroupException {

    public CreateGroupException(String s) {
        super(s);
    }

    public CreateGroupException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
