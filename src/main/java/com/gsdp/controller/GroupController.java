package com.gsdp.controller;

import com.google.gson.Gson;
import com.gsdp.dto.JsonData;
import com.gsdp.dto.group.GroupMember;
import com.gsdp.dto.group.GroupMemberWithCurrentUserRole;
import com.gsdp.entity.group.Activity;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.group.Situation;
import com.gsdp.entity.user.User;
import com.gsdp.enums.BaseStatusInfo;
import com.gsdp.enums.file.FileStatusInfo;
import com.gsdp.enums.group.GroupStatus;
import com.gsdp.enums.group.GroupStatusInfo;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.exception.file.EmptyFileException;
import com.gsdp.exception.file.FormatNotMatchException;
import com.gsdp.exception.file.SizeBeyondException;
import com.gsdp.exception.group.*;
import com.gsdp.exception.news.NewsException;
import com.gsdp.service.ActivityService;
import com.gsdp.service.GroupService;
import com.gsdp.service.SituationService;
import com.gsdp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/31 创造的作品
 * ********************************************************
 * +描述:组织相关的控制类
 *********************************************************/
@Controller
@RequestMapping("/group")
public class GroupController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SituationService situationService;

    @RequestMapping(value = "/list")
    public String getGroupListMsg(Model model) {

        logger.info("获取所有组织列表");

        List<Group> groupList = groupService.getAllGroupListMsg(0, 0, "visitors", true);

        Gson gson = new Gson();

        logger.info(gson.toJson(groupList));

        model.addAttribute("groupList", groupList);

        return "groupList";
    }

    @RequestMapping(value = "/{typeId}/list")
    public String getGroupListMsg(@PathVariable("typeId") int typeId, Model model) {

        logger.info("获取组织列表");

        List<Group> groupList = groupService.getGroupListMsg(typeId, 0, 0, "visitors", true);

        Gson gson = new Gson();

        logger.info(gson.toJson(groupList));

        model.addAttribute("groupList", groupList);

        return "groupList";
    }

    @RequestMapping(value = "/{groupId}/detail")
    public String getGroupDetatilMsg(@PathVariable("groupId") int groupId, HttpSession session, Model model) {

        logger.info("获取组织详细信息");

        Map<Integer, String> identities = null;

        String identity = null;

        if (session.getAttribute("identities") != null) {
            identities = (Map<Integer, String>) session.getAttribute("identities");
            identity = identities.get(groupId);
        }

        Group group = groupService.getGroupMsg(groupId);

        List<Activity> activityList = null;

        if (!("visitor".equals(identity)) && (identity != null)) {
            activityList = activityService.getGeneralActivityMessage(groupId, 0, 0, "visitors", true);
        } else {
            activityList = activityService.getOpenActivityMessage(groupId, 0, 0, "visitors", true);

        }
        List<Situation> situationList = situationService.getSituationMessage(groupId, 0, 10, "visitors", true);

        List<Group> groupList = groupService.getGroupListMessageExpGroup(groupId);

        /**
         * 资源部分的功能还待设计样式和初始化方式
         */

        model.addAttribute("group", group);
        model.addAttribute("activityList", activityList);
        model.addAttribute("situationList", situationList);
        model.addAttribute("groupList", groupList);

        logger.info(gson.toJson(group));

        return "groupMsg";

    }

    /**
     * 参数单独给出，而不给对象，怕用户直接猜后端实体类属性，然后直接拼过来。
     *
     * @param groupName
     * @param groupContact
     * @param groupAddress
     * @param groupType
     * @param groupDec
     * @param multipartFile
     * @return 在这里有一点非常重要的是，当我们返回的对象是json，但是我们返回的
     * 实际对象里面没有get和set方法是要报406异常的。
     */
    @RequestMapping(value = "/creation", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonData createGroup(String groupName, String groupContact, String groupAddress,
                                int groupType, String groupDec, @RequestParam("checkFile") MultipartFile multipartFile, HttpSession session) {

        int currentUserId = ((User)session.getAttribute("user")).getUserId();

        String rootPath = session.getServletContext().getRealPath("/");

        Group group = new Group(groupName, groupDec, groupContact, groupAddress,
                groupType, currentUserId, 1, GroupStatus.APPLYING.getState());
        try {
            Group result = groupService.createGroup(currentUserId, group, rootPath, multipartFile);
            if (result != null) {
                return new JsonData(true, result, GroupStatusInfo.APPLICATION_HAS_BEEN_SUBMITTED.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.APPLICATION_SUBMISSION_FAILED.getMessage());
            }
        } catch (EmptyFileException e) {
            return new JsonData(false, FileStatusInfo.EMPTY_FILE.getMessage());
        } catch (FormatNotMatchException e) {
            return new JsonData(false, FileStatusInfo.FORMAT_NOT_MATCH.getMessage());
        } catch (SizeBeyondException e) {
            return new JsonData(false, FileStatusInfo.SIZE_BEYOND.getMessage());
        } catch (IllegalArgumentException e) {
            return new JsonData(false, BaseStatusInfo.PARAMETER_ERROR.getMessage());
        } catch (GroupRepeatException e) {
            return new JsonData(false, GroupStatusInfo.GROUP_REPEAT.getMessage());
        } catch (SqlActionWrongException e) {
            //其它的异常（比如sqlException）我们统一返回服务器内部错误这种提示信息。
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/randomChangeGroupIcon", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData randomChangeGroupIcon(int groupId) {

        try {
            String groupIcon = groupService.randomChangeGroupIcon(groupId);
            if(null != groupIcon) {
                return new JsonData(true, groupIcon, GroupStatusInfo.CHANGE_GROUP_ICON_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.CHANGE_GROUP_ICON_FAIL.getMessage());
            }
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/ChangeGroupIcon", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData changeGroupIcon(int groupId, @RequestParam("groupIcon") MultipartFile multipartFile, HttpSession session) {
        String rootPath = session.getServletContext().getRealPath("/");
        try {
            String groupIcon = groupService.changeGroupIcon(groupId, multipartFile, rootPath);
            if(null != groupIcon) {
                return new JsonData(true, groupIcon, GroupStatusInfo.CHANGE_GROUP_ICON_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.CHANGE_GROUP_ICON_FAIL.getMessage());
            }
        } catch (EmptyFileException e) {
            return new JsonData(false, FileStatusInfo.EMPTY_FILE.getMessage());
        } catch (FormatNotMatchException e) {
            return new JsonData(false, FileStatusInfo.FORMAT_NOT_MATCH.getMessage());
        } catch (SizeBeyondException e) {
            return new JsonData(false, FileStatusInfo.SIZE_BEYOND.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/ChangeGroupInfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData changeGroupInfo(int groupId, String groupName, String groupContact, String groupAddress,
                                    int groupType, String groupDec) {
        try {
            if(groupService.changeGroupInfo(groupId, groupName, groupContact, groupAddress,groupType,groupDec)) {
                return new JsonData(true, "", GroupStatusInfo.CHANGE_GROUP_INFORMATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.CHANGE_GROUP_INFORMATION_FAIL.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return new JsonData(false, BaseStatusInfo.PARAMETER_ERROR.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/superAdmin/agreeCreateGroup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData agreeCreateGroup(int groupId) {
        //这个方法只能为系统管理员调用，我们统一在拦截器里面把这个url拦截掉，
        //同时这个地址也最好不要暴露出来。
        try {
            if (groupService.agreeCreateGroup(groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/superAdmin/disagreeCreateGroup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData disagreeCreateGroup(int groupId) {
        try {
            if (groupService.disagreeCreateGroup(groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }


    @RequestMapping(value = "/member/quit", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData quitGroup(int groupId, HttpSession session) {
        int userId = ((User) session.getAttribute("user")).getUserId();
        try {
            boolean message = groupService.quitGroup(userId, groupId);
            if (message) {
                return new JsonData(true, "", GroupStatusInfo.QUIT_GROUP_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.QUIT_GROUP_FAIL.getMessage());
            }
        } catch (NotInGroupException e) {
            return new JsonData(false, GroupStatusInfo.NOT_IN_THE_GROUP.getMessage());
        } catch (OwnerCanNotQuitGroupException e) {
            return new JsonData(false, GroupStatusInfo.OWNER_CAN_NOT_QUIT_GROUP.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/fireMember", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData fireFromGroup(int userId, int groupId, HttpSession session) {
        int currentUserId = ((User) session.getAttribute("user")).getUserId();

        try {
            if (groupService.fireMember(currentUserId, userId, groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (NotInGroupException e) {
            return new JsonData(false, GroupStatusInfo.NOT_IN_THE_GROUP.getMessage());
        } catch (OwnerCanNotQuitGroupException e) {
            return new JsonData(false, GroupStatusInfo.OWNER_CAN_NOT_QUIT_GROUP.getMessage());
        } catch (NotHasPermissionException e) {
            return new JsonData(false, GroupStatusInfo.NOT_HAS_PERMISSION.getMessage());
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/appointmentAdmin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData appointmentAdmin(int userId, int groupId) {
        try {
            if (groupService.addAdmin(userId, groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (NotInGroupException e) {
            return new JsonData(false, GroupStatusInfo.NOT_IN_THE_GROUP.getMessage());
        } catch (HasBeenAdminException e) {
            return new JsonData(false, GroupStatusInfo.HAS_BEEN_GROUP_ADMIN.getMessage());
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/owner/deleteAdmin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData deleteAdmin(int userId, int groupId) {
        try {
            if (groupService.deleteAdmin(userId, groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (NotInGroupException e) {
            return new JsonData(false, GroupStatusInfo.NOT_IN_THE_GROUP.getMessage());
        } catch (NotGroupAdminException e) {
            return new JsonData(false, GroupStatusInfo.IS_NOT_GROUP_ADMIN.getMessage());
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/owner/changeOwner", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData changeOwner(int userId, int groupId, HttpSession session) {

        int currentOwner = ((User) session.getAttribute("user")).getUserId();
        try {
            if (groupService.changeOwner(currentOwner, userId, groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OWNER_CHANGE_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OWNER_CHANGE_FAIL.getMessage());
            }
        } catch (NotInGroupException e) {
            return new JsonData(false, GroupStatusInfo.OWNER_CHANGE_FAIL.getMessage());
        } catch (HasBeenOwnerException e) {
            return new JsonData(false, GroupStatusInfo.HAS_BEEN_GROUP_OWNER.getMessage());
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OWNER_CHANGE_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/applyMembers", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData getGroupApplyMembers(int groupId, int currentPage, int limit) {

        try {
            GroupMember groupMember = groupService.getGroupMembersByStatus(groupId, 0, currentPage, limit);
            if (null != groupMember) {
                return new JsonData(true, groupMember, GroupStatusInfo.GET_GROUP_APPLY_MEMBER_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.GET_GROUP_APPLY_MEMBER_FAILED.getMessage());
            }
        } catch (GroupNotExistException e) {
            return new JsonData(false, GroupStatusInfo.GROUP_NOT_EXIST.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/member/members", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData getGroupMembers(int groupId, int currentPage, int limit, HttpSession session) {
        int currentUserId = ((User) session.getAttribute("user")).getUserId();
        try {
            GroupMemberWithCurrentUserRole groupMemberWithCurrentUserRole =
                    groupService.getGroupMembersWithRoleByStatus(groupId, 1, currentUserId, currentPage, limit);
            return new JsonData(true, groupMemberWithCurrentUserRole, GroupStatusInfo.GET_GROUP_MEMBER_SUCCESS.getMessage());
        } catch (GroupNotExistException e) {
            return new JsonData(false, GroupStatusInfo.GROUP_NOT_EXIST.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/agreeJoin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData agreeUserJoinGroup(int userId, int groupId) {
        try {
            if (groupService.agreeUserJoinGroup(userId, groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (HasBeenMemberException e) {
            return new JsonData(false, GroupStatusInfo.HAS_BEEN_GROUP_MEMBER.getMessage());
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/admin/disagreeJoin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData disagreeJoinGroup(int userId, int groupId) {

        try {
            if (groupService.disagreeUserJoinGroup(userId, groupId)) {
                return new JsonData(true, "", GroupStatusInfo.OPERATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
            }
        } catch (NewsException e) {
            return new JsonData(false, GroupStatusInfo.OPERATION_FAIL.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }


    /*
    *****************
    所有app接口
    *************
    * */

    @RequestMapping(value = "/app/list", method = RequestMethod.GET)
    @ResponseBody
    public JsonData queryAllGroups() {
        List<Group> groupList = groupService.getAllGroupListMsg(0, 0, "visitors", true);
        return new JsonData(true, groupList, GroupStatusInfo.GET_GROUP_MESSAGE_SUCCESS.getMessage());
    }

    @RequestMapping(value = "/app/listWithOwner", method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAllGroupMessagesWithOwner() {
        try {
            List<Group> allGroupMessageWithOwner = groupService.getAllGroupMessagesWithOwner();
            return new JsonData(true, allGroupMessageWithOwner, GroupStatusInfo.GET_GROUP_MESSAGE_SUCCESS.getMessage());
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

    @RequestMapping(value = "/app/{groupId}/detail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public JsonData getGroupMessageWithOwner(@PathVariable("groupId") int groupId) {

        try {
            Group group = groupService.getGroupMessageWithOwner(groupId);
            if (null != group) {
                return new JsonData(true, group, GroupStatusInfo.GET_GROUP_MESSAGE_SUCCESS.getMessage());
            } else {
                return new JsonData(false, GroupStatusInfo.GROUP_NOT_EXIST.getMessage());
            }
        } catch (SqlActionWrongException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
    }

}
