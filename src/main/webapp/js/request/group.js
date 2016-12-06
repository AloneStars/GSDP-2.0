/**
 * Created by yizijun on 2016/11/1 0001.
 */
var group = {

    "url" : {
        "groupCreation" : function () {
            return "/gsdp/group/creation";
        },

        "getGroupApplyMembers" : function () {
            return "/gsdp/group/admin/applyMembers";
        },

        "getGroupMembers" : function () {
          return "/gsdp/group/member/members";
        },

        "agreeUserJoinGroup" : function () {
            return "/gsdp/group/admin/agreeJoin"
        },

        "disagreeUserJoinGroup" : function () {
            return "/gsdp/group/admin/disagreeJoin";
        },

        "quitGroup" : function () {
            return "/gsdp/group/member/quit";
        },

        "fireFromGroup" : function () {
            return "/gsdp/group/admin/fireMember";
        },

        "appointmentAdmin" : function () {
            return "/gsdp/group/admin/appointmentAdmin";
        },

        "deleteAdmin" : function () {
            return "/gsdp/group/owner/deleteAdmin";
        },

        "changeOwner" : function () {
            return "/gsdp/group/owner/changeOwner";
        }
    },

    //分页参数
    "pagination" : {

        "groupApplyMember" : {
            "totalPages" : 0,
            "initCurrentPage" : 1,
            "limit" : 8
        },

        "groupMember" : {
            "totalPages" : 0,
            "initCurrentPage" : 1,
            "limit" : 8
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

    "closeCreateGroupDialog"  : function() {
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

    "closeJoinGroupDialog" : function () {
        $("#join-group-form div").removeClass("has-error has-success");
        $("#join-group-form .err-info").html("");
        $("#join-group-form")[0].reset();
    },

    /**
     * 显示团队成员申请管理时完成的动作
     */
    "showGroupApplyMemberManager" : function () {
        group.getGroupApplyMembers(group.pagination.groupApplyMember.initCurrentPage,
            group.pagination.groupApplyMember.limit);
        group.initGroupApplyMembersPagination(group.pagination.groupApplyMember.totalPages,
            group.pagination.groupApplyMember.limit);
        dialog.showDialog(parseInt($(".group-apply-member-manager-size").css("min-height")),
        $(".group-apply-member-manager-size").outerWidth(),"group-apply-member-manager-dialog")
    },

    /**
     * 显示团队成员
     */
    "showGroupMemberManager" : function () {
        group.getGroupMembers(group.pagination.groupMember.initCurrentPage,
        group.pagination.groupMember.limit);
        group.initGroupMemberPagination(group.pagination.groupMember.totalPages,
        group.pagination.groupMember.limit);
        dialog.showDialog(parseInt($(".group-member-manager-size").css("min-height")),
            $(".group-member-manager-size").outerWidth(),"group-member-manager-dialog");
    },

    //显示发布通知模态框
    "showPublishNotice" : function () {
        dialog.showDialog(parseInt($(".publish-notice-size").css("min-height")),
        $(".publish-notice-size").outerWidth(), "publish-notice-dialog");
    },

    "getGroupApplyMembers" : function (currentPage, limit) {
        var groupId = $("#groupId").text();

        $.ajax({
            url : group.url.getGroupApplyMembers(),
            type : "post",
            dataType : "json",
            async : false,
            data : {
                "groupId" : groupId,
                "currentPage" : currentPage,
                "limit" : limit
            },
            success : function (data) {
                if(data.success) {
                    $("#group-apply-member-manager-table td").html("");
                    for(var i = 0; i < data.data.members.length; ++i) {
                        $("#group-apply-member-manager-table tbody tr:eq(" + i + ") td:eq(0)").html(i + 1);
                        $("#group-apply-member-manager-table tbody tr:eq(" + i + ") td:eq(1)").html(data.data.members[i].user.username);
                        $("#group-apply-member-manager-table tbody tr:eq(" + i + ") td:eq(2)").html(data.data.members[i].phone);
                        $("#group-apply-member-manager-table tbody tr:eq(" + i + ") td:eq(3)").html("<nobr>" + data.data.members[i].applyReason + "</nobr>");
                        $("#group-apply-member-manager-table tbody tr:eq(" + i + ") td:eq(4)").
                        attr("user-id",data.data.members[i].userId).html("<button type='button' title='同意' class='btn btn-info btn-sm'>√</button>" +
                                 "<button type='button' title='不同意' class='btn btn-sm btn-default'>×</button>");
                    }
                     group.pagination.groupApplyMember.totalPages = data.data.page.totalPages;
                } else {
                    alert(data.message);
                }
            },
            error : function () {
                //do nothing
            }
        });
    },

    "getGroupMembers" : function (currentPage, limit) {
        var groupId = $("#groupId").text();
        $.ajax({
            url : group.url.getGroupMembers(),
            type : "post",
            dataType : "json",
            async : false,
            data : {
                "groupId" : groupId,
                "currentPage" : currentPage,
                "limit" : limit
            },
            success : function (data) {
                if(data.success) {
                    //先把所有td标签里面的内容都清除掉
                    $("#group-member-manager-table td").html("");
                    for(var i = 0; i < data.data.groupMember.members.length; ++i) {

                        $("#group-member-manager-table tr:eq(" + i + ") td:eq(0)").
                        html("<img src='/gsdp/" + data.data.groupMember.members[i].user.headPicture + "'/>&nbsp;" +
                            data.data.groupMember.members[i].user.username);

                        $("#group-member-manager-table tr:eq(" + i + ") td:eq(1)").
                        html(user.reference.genderReference()[data.data.groupMember.members[i].user.sex][1]);

                        $("#group-member-manager-table tr:eq(" + i + ") td:eq(2)").
                        html(data.data.groupMember.members[i].user.age + "岁");

                        $("#group-member-manager-table tr:eq(" + i + ") td:eq(3)").
                        html(data.data.groupMember.members[i].role.roleName);

                        var operation = "";
                        var groupOwner = "<img src='/gsdp/image/role/group_owner.png' title='设置为法人' class='set-group-owner' style='cursor: pointer'/>&nbsp;";
                        var groupAdmin = "<img src='/gsdp/image/role/group_admin.png' title='设置为团队管理员' class='set-group-admin' style='cursor: pointer'/>&nbsp;";
                        var groupUser = "<img src='/gsdp/image/role/group_user.png' title='设置为普通成员' class='set-group-user' style='cursor: pointer'/>&nbsp;";
                        var fireMember = "<img src='/gsdp/image/role/fire_member.png' title='从该组织移除' class='fire-member' style='cursor: pointer'/>&nbsp;";
                        //首先要当前这个用户的权限有显示这个人的权限高才有资格操作
                        if(data.data.currentRole.roleId > data.data.groupMember.members[i].roleId) {
                            /*
                            如果当前这个人是这个社团的管理员，那么对它就有3个操作
                            1.设置为超级管理员 --- 》superAdmin
                            2.下降为普通用户    ----> groupUser
                            3.踢出该团队   ----> user
                             */
                            if(data.data.groupMember.members[i].roleId === 3) {
                                operation += (groupOwner + groupUser + fireMember);
                                /*
                                如果是普通成员的话，
                                法人对其有三个操作  1.superAdmin  2。user. 3 admin(普通管理员)
                                普通管理员对其有两个操作  1。admin   2 user
                                 */
                            } else if(data.data.groupMember.members[i].roleId === 2) {
                                if(data.data.currentRole.roleId === 4) {
                                    operation += (groupOwner + groupAdmin + fireMember);
                                }
                                if(data.data.currentRole.roleId === 3) {
                                    operation += (groupUser + fireMember);
                                }
                            }
                        }

                        //接下来是根据当前用户的角色动态的显示操作按钮
                        $("#group-member-manager-table tr:eq(" + i + ") td:eq(4)").attr("user-id",
                            data.data.groupMember.members[i].user.userId).html(operation);
                    }
                    //设置当前的总页数
                    group.pagination.groupMember.totalPages = data.data.groupMember.page.totalPages;
                } else {
                    alert(data.message);
                }
            },
            error : function () {
                //do nothing;
            }
        });
    },


    /**
     * 初始化团队成员申请管理的分页
     * @param totalNumbers
     * @param limit
     */
    "initGroupApplyMembersPagination" : function (totalPages, limit) {
        $("#group-apply-member-manager-dialog .modal-footer .M-box3").pagination({
            pageCount:totalPages,//总共的页数
            jump:true,
            coping:true,
            homePage:'首页',
            endPage:'末页',
            prevContent:'上页',
            nextContent:'下页',
            callback: function (api) {
                group.getGroupApplyMembers(api.getCurrent(), limit);
            }
        });
    },

    /**
     * 初始化团队成员管理的分页
     * @param totalPages
     * @param limit
     */
    "initGroupMemberPagination" : function (totalPages, limit) {
        $("#group-member-manager-dialog .modal-footer .M-box3").pagination({
            pageCount:totalPages,//总共的页数
            jump:true,
            coping:true,
            homePage:'首页',
            endPage:'末页',
            prevContent:'上页',
            nextContent:'下页',
            callback: function (api) {
                group.getGroupMembers(api.getCurrent(), limit);
            }
        });
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
                dataType : "json",
                data : {
                    "groupName" : groupName,
                    "groupContact" : groupContact,
                    "groupAddress" : groupAddress,
                    "groupType" : groupType,
                    "groupDec" : groupDec
                },
                success : function(data) {
                   alert(data);
                }
            });
        }
    },

    /**
     * 同意用户加入团队
     */
    "agreeUserJoinGroup" : function (userId) {
        var groupId = $("#groupId").text();

        $.post(group.url.agreeUserJoinGroup(),
            {
                "userId" : userId,
                "groupId" : groupId
            }, function (data) {
                if(data.success) {
                    group.getGroupApplyMembers(group.pagination.groupApplyMember.initCurrentPage,
                        group.pagination.groupApplyMember.limit);
                    group.initGroupApplyMembersPagination(group.pagination.groupApplyMember.totalPages,
                        group.pagination.groupApplyMember.limit);
                } else {
                    alert(data.message);
                }
            });
    },

    /**
     * 不同意该用户加入该团队的申请
     */
    "disagreeUserJoinGroup" : function (userId) {

        var groupId = $("#groupId").text();
        $.post(group.url.disagreeUserJoinGroup(),
            {
                "userId" : userId,
                "groupId" : groupId
            },function (data) {
                if(data.success) {
                    group.getGroupApplyMembers(group.pagination.groupApplyMember.initCurrentPage,
                        group.pagination.groupApplyMember.limit);
                    group.initGroupApplyMembersPagination(group.pagination.groupApplyMember.totalPages,
                        group.pagination.groupApplyMember.limit);
                } else {
                    alert(data.message);
                }
            });
    },

    /**
    把某人从组织中开除了
     */
    "fireMember" : function (userId) {
        var groupId = $("#groupId").text();
        $.post(group.url.fireFromGroup(),
            {
                "groupId" : groupId,
                "userId" : userId
            },function (data) {
                if(data.success) {
                    //TODO  这里还有一点瑕疵，每次用户操作完都是跳到第一页，到时候修改到不跳到第一页
                    group.getGroupMembers(group.pagination.groupMember.initCurrentPage,
                        group.pagination.groupMember.limit);
                    group.initGroupMemberPagination(group.pagination.groupMember.totalPages,
                        group.pagination.groupMember.limit);
                } else {
                    alert(data.message);
                }
            }
        )
    },

    /**
     * 任命当前组织的普通用户为管理员
     * @param userId
     */
    "appointmentAdmin" : function (userId) {
        var groupId = $("#groupId").text();
        $.post(group.url.appointmentAdmin(),
            {
                "groupId" : groupId,
                "userId" : userId
            },function (data) {
                if(data.success) {
                    //TODO  这里还有一点瑕疵，每次用户操作完都是跳到第一页，到时候修改到不跳到第一页
                    group.getGroupMembers(group.pagination.groupMember.initCurrentPage,
                        group.pagination.groupMember.limit);
                    group.initGroupMemberPagination(group.pagination.groupMember.totalPages,
                        group.pagination.groupMember.limit);
                } else {
                    alert(data.message);
                }
            }
        )
    },

    /**
     * 把当前组织的管理员解雇（也就是变成普通成员）
     * @param userId
     */
    "deleteAdmin" : function (userId) {
        var groupId = $("#groupId").text();
        $.post(group.url.deleteAdmin(),
            {
                "groupId" : groupId,
                "userId" : userId
            },function (data) {
                if(data.success) {
                    //TODO  这里还有一点瑕疵，每次用户操作完都是跳到第一页，到时候修改到不跳到第一页
                    group.getGroupMembers(group.pagination.groupMember.initCurrentPage,
                        group.pagination.groupMember.limit);
                    group.initGroupMemberPagination(group.pagination.groupMember.totalPages,
                        group.pagination.groupMember.limit);
                } else {
                    alert(data.message);
                }
            }
        )
    },

    /**
     * 把当前组织中指定的一个人设置为法人
     * @param userId
     */
    "changeOwner" : function (userId) {
        var groupId = $("#groupId").text();
        $.post(group.url.changeOwner(),
            {
                "groupId" : groupId,
                "userId" : userId
            },function (data) {
                if(data.success) {
                    //TODO  这里还有一点瑕疵，每次用户操作完都是跳到第一页，到时候修改到不跳到第一页
                    group.getGroupMembers(group.pagination.groupMember.initCurrentPage,
                        group.pagination.groupMember.limit);
                    group.initGroupMemberPagination(group.pagination.groupMember.totalPages,
                        group.pagination.groupMember.limit);
                } else {
                    alert(data.message);
                }
            }
        )
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

    //当点击同意按钮的时候
    /*
    注意这里我在tbody td.operation > button：eq(0)这种选择器的时候有点坑，其只会选择第一个，而不是
    选择所有button下面的第一个
     */
    $("#group-apply-member-manager-table").on("click","tbody td.operation > button[title='同意']", function () {
        group.agreeUserJoinGroup($(this).parent().attr("user-id"));
    });

    //当点击不同意按钮的时候
    $("#group-apply-member-manager-table").on("click", "tbody td.operation > button[title='不同意']", function () {
        group.disagreeUserJoinGroup($(this).parent().attr("user-id"));
    });


    //把某人从组织中移除
    $("#group-member-manager-table").on("click", ".fire-member", function () {
        group.fireMember($(this).parent().attr("user-id"));
    });

    //任命当前组织的普通用户为管理员
    $("#group-member-manager-table").on("click", ".set-group-admin", function () {
        group.appointmentAdmin($(this).parent().attr("user-id"));
    });

    //把当前组织的管理员解雇（也就是变成普通成员）
    $("#group-member-manager-table").on("click", ".set-group-user", function () {
        group.deleteAdmin($(this).parent().attr("user-id"));
    });

    //把当前社团的成员变成法人
    $("#group-member-manager-table").on("click", ".set-group-owner", function () {
        group.changeOwner($(this).parent().attr("user-id"));
    });


});
