package com.gsdp.dto;

import java.util.Date;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/1 创造的作品
 * ********************************************************
 * +描述:数据传输过程中的json封装串
 *********************************************************/
public class JsonCode {

    //返回码
    private String errCode;

    //返回类容
    private String context;

    //创建时间
    private Date createTime;

    public JsonCode(String context, Date createTime, String errCode) {
        this.context = context;
        this.createTime = createTime;
        this.errCode = errCode;
    }


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JsonCode{" +
                "context='" + context + '\'' +
                ", errCode='" + errCode + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
