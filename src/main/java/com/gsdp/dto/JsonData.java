package com.gsdp.dto;

/**
 * Created by yizijun on 2016/11/5 0005.
 */
public class JsonData {

    private boolean success;

    private Object data;

    private String message;

    public JsonData(boolean success, Object data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public JsonData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
