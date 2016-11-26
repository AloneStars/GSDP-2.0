package com.gsdp.util;

/**
 * Created by yizijun on 2016/11/21 0021.
 */
public class UserUtil {

    /**
     * 1.验证用户名:用户名长度在【1,15】之间，不能够为空白字符和特殊符号,只能为中文，大小写字母和数字
     */

    public static boolean checkUsername(String username) {
        return true;
    }

    /**
     *
     * 验证密码:密码长度在【6,16】之间，可以为大小写字母，数字，键盘上面的所有小写字符，不能够为空白字符
     */
    public static boolean checkPassword(String password) {
        return true;
    }

    /**
     * 为[1,9]位的正整数
     * @param age
     * @return
     */
    public static boolean checkUserAge(int age) {
        return true;
    }

    /**
     * 验证用户的性别只能为0，1,2这三个数
     * @param sex
     * @return
     */
    public static boolean checkUserSex(int sex) {
        return true;
    }

    /**
     * 这里做一个判空的操作就够了
     * @param weChat
     * @return
     */
    public static boolean checkUserWechat(String weChat) {
        return true;
    }

    /**
     * 用户输入的个人介绍字数在[5,100]之间，并且不能有空白符
     * @param personIntroduce
     * @return
     */
    public static boolean checkPersonIntroduce(String personIntroduce) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
