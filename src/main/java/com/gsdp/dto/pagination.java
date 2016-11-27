package com.gsdp.dto;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/26 创造的作品
 * ********************************************************
 * +描述:关于分类的实体类
 *********************************************************/
public class Pagination {

    //总页数
    private int totalPage;

    //目前的页数
    private int currentPage;

    //每页显示的数量
    private int showData;

    public Pagination(int totalPage,int currentPage, int showData) {
        this.currentPage = currentPage;
        this.showData = showData;
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getShowData() {
        return showData;
    }

    public void setShowData(int showData) {
        this.showData = showData;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /***********toString*************/
    @Override
    public String toString() {
        return "Pagination{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", showData=" + showData +
                '}';
    }
}
