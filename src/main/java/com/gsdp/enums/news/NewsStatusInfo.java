package com.gsdp.enums.news;

/**
 * Created by yizijun on 2016/11/27 0027.
 */
public enum NewsStatusInfo {

    SYSTEM_NEWS_TITLE(1, "系统消息"),

    ;

    private int state;

    private String message;

    private NewsStatusInfo(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static NewsStatusInfo getNewsStatusInfo(int state) {

        for(NewsStatusInfo newsStatusInfo : values()) {
            if(newsStatusInfo.getState() == state) {
                return newsStatusInfo;
            }
        }
        return null;
    }
}
