package com.gsdp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/30 创造的作品
 * ********************************************************
 * +描述:团队验证的工具类
 *********************************************************/
public class ActivityUtil {

    //验证字符串是否为空
    public static boolean checkStr(String str){

        if(str == null || str.length()<=0)
            return false;
        else
            return true;

    }

    //验证开始时间是否早于今天
    public static boolean checkStartTime(String startTime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date today = null;
        Date startDate = null;

        try {
            today = sdf.parse(DateUtil.getDataString());
            startDate = sdf.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(startDate.before(today));

        if(startDate == null || startDate.before(today))
            return false;
        else
            return true;

    }

    //验证结束时间是否早于开始时间
    public static boolean checkEndTime(String startTime,String endTime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date endDate = null;
        Date startDate = null;

        try {
            startDate = sdf.parse(startTime);
            endDate = sdf.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(endDate == null || startDate== null || endDate.before(startDate))
            return false;
        else
            return true;

    }

    //验证字符串长度是否符合
    public static boolean checkStrLength(String str,int start,int end){

        if(str != null){
            if(str.length()<start||str.length()>end)
                return false;
            else
                return true;
        }else
            return false;

    }

    //验证开放权限
    public static boolean checkOpen(int open){

        if(open!= 0 && open != 1)
            return false;
        else
            return true;

    }

    public static void main(String[] args) {
        System.out.println(checkStartTime("2016-12-13"));
    }

}
