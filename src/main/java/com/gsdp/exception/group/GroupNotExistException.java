package com.gsdp.exception.group;

/**
 * 团队不存在的异常
 * Created by yizijun on 2016/11/27 0027.
 */
public class GroupNotExistException extends GroupException {

    public GroupNotExistException(String s) {
        super(s);
    }

    public GroupNotExistException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
