package com.gsdp.exception.group;

/**
 * Created by yizijun on 2016/12/1 0001.
 */
public class OwnerCanNotQuitGroupException extends GroupException {

    public OwnerCanNotQuitGroupException(String s) {
        super(s);
    }

    public OwnerCanNotQuitGroupException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
