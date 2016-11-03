package com.gsdp.util;


import com.gsdp.enums.group.GroupType;

/**
 * Created by yizijun on 2016/11/2 0002.
 */
public class GroupUtil {

    /**
     * 验证申请团队所传文件的格式
     * @param fileName
     * @return
     */
    public static boolean isSpecialFormat(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String accept = "jpeg|jpg|doc"; //想增加其他格式就在这里改，
        if(-1 != accept.indexOf(suffix)) {
            return true;
        }
        return false;
    }

    /**
     *
     限制团队名称不能为数字和空白字符，并且长度在[1,10]之间
     *
     * @param groupName
     * @return
     */
    public static boolean checkGroupName(String groupName) {
        String regex = "^[^0-9\\s]{1,10}$";
        if(groupName.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证用户输入的联系方式只能为手机号码
     * @param groupContact
     * @return
     */
    public static boolean checkGroupContact(String groupContact) {
        String regex = "^1[34578]\\d{9}$";
        if(groupContact.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 限制团队办公地点的输入长度只能在[5,25]之间
     * @param groupAddress
     * @return
     */
    public static boolean checkGroupAddress(String groupAddress) {
        if(groupAddress.length() >= 5 && groupAddress.length() <= 25) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断用户传过来的团队类型是否是指定的类型
     * @param groupTypeId
     * @return
     */
    public static boolean checkGroupType(int groupTypeId) {
        if(null != GroupType.getGroupType(groupTypeId)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isSpecialFormat("dkfjdfj.f.jpgg"));
//        System.out.println(checkGroupName("aaaaaaaaaaa"));
//          System.out.println(checkGroupContact("13811111111"));
        System.out.println(checkGroupType(7));

    }
}
