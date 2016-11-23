package com.gsdp.exception.situation;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public class SituationException extends RuntimeException {

    public SituationException(String s) {
        super(s);
    }

    public SituationException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
