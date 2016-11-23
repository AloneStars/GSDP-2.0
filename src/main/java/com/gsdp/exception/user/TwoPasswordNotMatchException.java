package com.gsdp.exception.user;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public class TwoPasswordNotMatchException extends UserException {

    public TwoPasswordNotMatchException(String s) {
        super(s);
    }

    public TwoPasswordNotMatchException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
