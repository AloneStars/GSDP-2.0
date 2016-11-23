package com.gsdp.exception.file;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public class FormatNotMatchException extends FileException {

    public FormatNotMatchException(String s) {
        super(s);
    }

    public FormatNotMatchException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
