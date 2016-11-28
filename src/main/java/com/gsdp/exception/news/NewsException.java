package com.gsdp.exception.news;

/**
 * Created by yizijun on 2016/11/28 0028.
 */
public class NewsException extends RuntimeException {

    public NewsException(String s) {
        super(s);
    }

    public NewsException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
