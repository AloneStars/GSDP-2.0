/**
 * Created by yizijun on 2016/11/1 0001.
 */
var group = {

    "url" : {
        "groupCreation" : function () {
            return "/GSDP/group/creation";
        }
    },

    "checkGroupName" : function (groupName) {
        /*
        限制团队名称不能为数字和空白字符，并且长度在[1,10]之间
         */
        var regex = /^[^0-9\n\f\r\t\v]{1,10}$/;
        if(groupName && regex.test(groupName)) {
            return true;
        } else {
            return false;
        }
    },
    
    "checkGroupContact" : function (groupContact) {
        //验证用户输入的手机号格式
        var regex = /^1[34578]\d{9}$/;
        if(groupContact && regex.test(groupContact)) {
            return true;
        } else {
            return false;
        }
    },
    
    "checkGroupAddress" : function (groupAddress) {
        //限制团队办公地点的输入长度只能在[5,25]之间
        if(groupAddress && groupAddress.length >= 5 && groupAddress.length <= 25) {
            return true;
        } else {
            return false;
        }
    },
    
    "checkProfile" : function (profile) {
        if(profile) {
            return true;
        } else {
            return false;
        }
    },

    "checkGroupDec" : function (groupDec) {
        //限制团队输入的介绍在[10,255]之间
        if(groupDec.length >= 10 && groupDec.length <= 255) {
            return true;
        } else {
            return false;
        }
    },

    "checkGroupType" : function (groupType) {
        //输入的groupType必须全部是数字
        if(!isNaN(groupType)) {
            return true;
        } else {
            return false;
        }
    },
    
    "groupCreation" : function () {
        /*
        1.检查输入数据的合法性(团队名称，手机号码，办公地点，佐证材料，团队介绍)
        2.发送post请求调用服务端
        3.根据服务端返回数据做出相应响应
         */
        var groupName = $("#group_name").val();
        var groupContact = $("#contact").val();
        var groupAddress = $("#work_address").val();
        var profile = $("#profile").val();
        var groupDec = $("#group_introduce").val();
        var groupType = $("#group_type").val();

        if(group.checkGroupName(groupName) && group.checkGroupContact(groupContact) &&
          group.checkGroupAddress(groupAddress) && group.checkProfile(profile) &&
          group.checkGroupDec(groupDec) && group.checkGroupType(groupType)) {
                return true;
        } else {
            return false;
        }
    }
};