package com.gsdp.exception.user;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public class UserException extends RuntimeException {

    public UserException(String s) {
        super(s);
    }

    public UserException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
