/**
 * Created by yizijun on 2016/11/1 0001.
 */
var group = {

    "url" : {
        "groupCreation" : function () {
            return "/gsdp/group/creation";
        }
    },

    "check" : {

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
        }
    },


    //返回当前节点前面指定nodeType类型的节点
    "getPreviousSibling" : function (node, nodeType) {
        var preNode = node.previousSibling;
        while (preNode && preNode.nodeType != nodeType) {
            preNode = preNode.previousSibling;
        }
        if(preNode && preNode.nodeType == nodeType) {
            return preNode;
        } else {
            return null;
        }
    },

    //还原dialog
    "recoveryCreateGroupDialog"  : function() {
        /*
        1.把所有的提示信息全部清除，
        2.把所有的表单信息全部复位
        3.把选择文件的文字复位
         */
        $("#group-creation-form div").removeClass("has-error has-success");
        $("div.err-info").html("");
        group.getPreviousSibling($("#profile")[0], 3).nodeValue = "选择文件";
        //把所有的表单清空，这里注意如何把jquery对象转化为Dom对象
        $("#group-creation-form")[0].reset();
    },

    "showCreateGroupDialog" : function () {
        dialog.showDialog(parseInt($(".create-group-size").css("min-height")),
            $(".create-group-size").outerWidth(), "create-group-dialog");
    },

    "showJoinGroupDialog" : function () {
        dialog.showDialog(parseInt($(".join-group-size").css("min-height")),
            $(".join-group-size").outerWidth(), "join-group-dialog");
    },

    "showGroupApplyMemberManager" : function () {
        dialog.showDialog(parseInt($(".group-apply-member-manager-size").css("min-height")),
        $(".group-apply-member-manager-size").outerWidth(),"group-apply-member-manager-dialog")
    },

    "closeCreateGroupDialog" : function () {
        dialog.closeDialog();
        group.recoveryCreateGroupDialog();
    },

    "groupCreation" : function () {
        /*
        1.检查输入数据的合法性(团队名称，手机号码，办公地点，佐证材料，团队介绍)
        2.发送post请求调用服务端
        3.根据服务端返回数据做出相应响应
         */
        var groupName = $("#group_name").val();
        var groupContact = $("#create-group-contact").val();
        var groupAddress = $("#work_address").val();
        var profile = $("#profile").val();
        var groupDec = $("#group_introduce").val();
        var groupType = $("#group_type").val();

        if(group.check.checkGroupName(groupName) && group.check.checkGroupContact(groupContact) &&
          group.check.checkGroupAddress(groupAddress) && group.check.checkProfile(profile) &&
          group.check.checkGroupDec(groupDec) && group.check.checkGroupType(groupType)) {

            //实现文件和数据同时提交（异步），在这里我们用了一个插件
            $.ajaxFileUpload({
                type : "post",
                url : group.url.groupCreation(),
                secureuri : false,
                fileElementId : "profile",
                dataType : "JSON",
                data : {
                    "groupName" : groupName,
                    "groupContact" : groupContact,
                    "groupAddress" : groupAddress,
                    "groupType" : groupType,
                    "groupDec" : groupDec
                },
                success : function(data, status) {
                   alert(data);
                }
            });
        }
    }

    //TODO
};


$(function () {
    //实现用户输入团队名称的提示
    $("#group_name").on("blur",function () {
        if(group.check.checkGroupName($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next().html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next().html("请输入正确的团队名称格式");
        }
    });

//实现用户输入电话号码的提示
    $("#create-group-contact").on("blur", function () {
        if(group.check.checkGroupContact($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next().html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next().html("请输入正确的手机号码格式");
        }
    });

    //实现用户输入办公地址的提示
    $("#work_address").on("blur", function () {
        if(group.check.checkGroupAddress($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next().html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next().html("请输入正确的办公地址格式");
        }
    });


    //实现用户输入团队介绍的提示
    $("#group_introduce").on("blur", function () {
        if(group.check.checkGroupDec($(this).val())) {
            $(this).parent().removeClass("has-error").addClass("has-success");
            $(this).next().html("");
        } else {
            $(this).parent().removeClass("has-success").addClass("has-error");
            $(this).next().html("请检查团队介绍的格式");
        }
    });


    //实现用户选择文件的效果
    $("#group-creation-form").on("change", "#profile", function () {
        var value = $(this).val();
        var preNode = group.getPreviousSibling(this, 3);
        if (preNode && value) {
            preNode.nodeValue = value.substring(value.lastIndexOf("\\") + 1);
        } else {
            preNode.nodeValue = "选择文件";
        }
    });

    //提交当前创建组织的表单
    $("#submit-apply-group").on("click", function () {
        group.groupCreation();
    });

});
