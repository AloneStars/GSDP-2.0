package com.gsdp.exception;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public class SizeBeyondException extends FileException {

    public SizeBeyondException(String s) {
        super(s);
    }

    public SizeBeyondException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
