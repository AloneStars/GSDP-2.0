package com.gsdp.dto;
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
    private Object context;

    //创建时间
    private String Message;

    public JsonCode(String context, String Message, String errCode) {
        this.context = context;
        this.Message = Message;
        this.errCode = errCode;
    }


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "JsonCode{" +
                "context='" + context + '\'' +
                ", errCode='" + errCode + '\'' +
                ", Message=" + Message +
                '}';
    }
}
