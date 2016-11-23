package com.gsdp.exception.file;

/**
 * Created by yizijun on 2016/11/3 0003.
 */
public class FileException extends RuntimeException  {

    public FileException(String s) {
        super(s);
    }

    public FileException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
