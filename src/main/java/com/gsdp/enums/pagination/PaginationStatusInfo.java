package com.gsdp.enums.pagination;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/27 创造的作品
 * ********************************************************
 * +描述:关于分页状态的枚举类
 *********************************************************/
public enum  PaginationStatusInfo {

    PAGINATION_SUCCESS(1,"分页信息获取成功")
    ;

    private int status;

    private String message;

    PaginationStatusInfo( int status,String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static PaginationStatusInfo getPaginationStatusInfo(int status){
        for (PaginationStatusInfo paginationStatusInfo: values()) {
            if(paginationStatusInfo.getStatus() == status)
                return paginationStatusInfo;
        }
        return null;
    }

}
