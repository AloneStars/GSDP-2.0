package com.gsdp.enums.file;

/**
 * Created by yizijun on 2016/11/5 0005.
 */
public enum FileStatusInfo {

    EMPTY_FILE(-1, "文件为空"),
    FORMAT_NOT_MATCH(-2, "文件扩展名不匹配"),
    SIZE_BEYOND(-3, "文件过大"),
    UPLOAD_FAIL(-4, "文件上传失败"),
    UPLOAD_SUCCESS(1, "文件上传成功")
    ;

    private int statue;

    private String message;

    FileStatusInfo(int statue, String message) {
        this.statue = statue;
        this.message = message;
    }

    public int getStatue() {
        return statue;
    }

    public String getMessage() {
        return message;
    }

    public static FileStatusInfo getFileStatusInfo(int state) {
        for (FileStatusInfo fileStatusInfo : values()) {
            if(fileStatusInfo.getStatue() == state) {
                return fileStatusInfo;
            }
        }
        return null;
    }
}
