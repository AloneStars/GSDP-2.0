package com.gsdp.exception.user;

/**
 * 两次密码输入不一致
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
