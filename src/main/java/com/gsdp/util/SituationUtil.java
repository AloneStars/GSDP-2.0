package com.gsdp.util;

/**
 * Created by yizijun on 2016/11/23 0023.
 */
public class SituationUtil {

    /**
     * 动态的名称在[1,50]位之间，不能全为空格
     * @param situationTitle
     * @return
     */
    public static boolean checkSituationTitle(String situationTitle) {
        if(situationTitle.replaceAll("\\s", "").length() == 0) {
            return false;
        }
        if(situationTitle.length() >= 1 && situationTitle.length() <= 50) {
            return true;
        }
        return false;
    }

    /**
     * 限制用户输入的内容在[10,maximumWords]之间
     * @param situationContent
     * @return
     */
    public static boolean checkSituationContent(String situationContent) {
        if(situationContent.length() >= 10 && situationContent.length() <= 2000) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkSituationTitle("        "));
//          System.out.println(checkSituationContent("iofdfjdfjd23322355"));
    }
}
