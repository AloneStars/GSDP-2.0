package com.gsdp.exception.news;

/**
 * 消息接收方为空的异常
 * Created by yizijun on 2016/11/28 0028.
 */
public class ReceiverIsEmptyException extends NewsException {

    public ReceiverIsEmptyException(String s) {
        super(s);
    }

    public ReceiverIsEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
