package com.gsdp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public class DateUtil {

    /**
     * 返回指定格式的时间字符串表示形式
     * @param regex
     * @return
     */
    public static String dateToString(String regex) {
        DateFormat dateFormat = new SimpleDateFormat(regex);
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(dateToString("yyyy-MM-dd"));
    }
}
