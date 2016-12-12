package com.gsdp.util;

/**
 * Created by yizijun on 2016/11/21 0021.
 */
public class UserUtil {

    /**
     * 1.验证用户名:用户名长度在【1,15】之间，不能够为空白字符和特殊符号,只能为中文，大小写字母和数字
     */

    public static boolean checkUsername(String username) {

        String regex = "^[\u4e00-\u9fa5a-zA-Z0-9]{1,15}$";
        boolean flag = username.matches(regex);

        return flag;
    }

    /**
     *
     * 验证密码:密码长度在【6,16】之间，可以为大小写字母，数字，键盘上面的所有小写字符，不能够为空白字符
     */
    public static boolean checkPassword(String password) {
        String regex="^[a-zA-Z0-9\\~`!@#$%^&*()_+=-|;:'\",<.>/?}[{]]{6,16}$";
        boolean flag = password.matches(regex);
        return flag;
    }

    /**
     * 为[1,9]位的正整数
     *
     * @param age
     * @return
     */
    public static boolean checkUserAge(int age) {

        String ageString = String.valueOf(age);
        String regex = "[1-9][0-9]{0,8}";
        boolean flag = ageString.matches(regex);
        return flag;
    }

    /**
     * 验证用户的性别只能为0，1,2这三个数
     *
     * @param sex
     * @return
     */
    public static boolean checkUserSex(int sex) {

        String sexString = String.valueOf(sex);
        String regex = "[0-2]{1}";
        boolean flag = sexString.matches(regex);
        return flag;
    }

    /**
     * 这里做一个判空的操作就够了
     *
     * @param weChat
     * @return
     */
    public static boolean checkUserWechat(String weChat) {
        boolean flag = false;
        if (null != weChat && weChat.matches("\\S+")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 用户输入的个人介绍字数在[5,100]之间，并且不能有空白符
     *
     * @param personIntroduce
     * @return
     */
    public static boolean checkPersonIntroduce(String personIntroduce) {
        String regex = ".{5,100}";
        boolean flag = personIntroduce.trim().matches(regex);
        return flag;
    }

    public static void main(String[] args) {

    }
}
