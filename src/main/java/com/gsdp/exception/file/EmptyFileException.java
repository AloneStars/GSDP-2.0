package com.gsdp.exception.file;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public class EmptyFileException extends FileException {

    public EmptyFileException(String s) {
        super(s);
    }

    public EmptyFileException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
