package com.gsdp.controller;

import com.google.gson.Gson;
import com.gsdp.dao.SituationDao;
import com.gsdp.dto.JsonData;
import com.gsdp.entity.group.Activity;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.group.Situation;
import com.gsdp.enums.file.FileStatusInfo;
import com.gsdp.enums.group.GroupStatusInfo;
import com.gsdp.exception.EmptyFileException;
import com.gsdp.exception.FormatNotMatchException;
import com.gsdp.exception.SizeBeyondException;
import com.gsdp.exception.group.CreateGroupException;
import com.gsdp.exception.group.GroupRepeatException;
import com.gsdp.service.ActivityService;
import com.gsdp.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    private GroupService groupService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SituationDao situationDao;

    @RequestMapping(value = "/list")
    public String getGroupListMsg(Model model){

        logger.info("获取所有组织列表");

        List<Group> groupList = groupService.getAllGroupListMsg(0,0,"visitors",true);

        Gson gson = new Gson();

        logger.info(gson.toJson(groupList));

        model.addAttribute("groupList",groupList);

        return "GroupList";
    }

    @RequestMapping(value = "/{typeId}/list")
    public String getGroupListMsg(@PathVariable("typeId") int typeId, Model model){

        logger.info("获取组织列表");

        List<Group> groupList = groupService.getGroupListMsg(typeId,0,0,"visitors",true);

        Gson gson = new Gson();

        logger.info(gson.toJson(groupList));

        model.addAttribute("groupList",groupList);

        return "GroupList";
    }

    @RequestMapping(value = "/{groupId}/detail")
    public String getGroupDetatilMsg(@PathVariable("groupId") int groupId,Model model){

        logger.info("获取组织详细信息");

        Group group = groupService.getGroupMsg(groupId);

        List<Activity> activityList = activityService.getActivityBySponsor(groupId);

        List<Situation> situationList = situationDao.getSituationMessage(groupId);

        /**
         * 资源部分的功能还待设计样式和初始化方式
         */

        model.addAttribute("group",group);
        model.addAttribute("activityList",activityList);
        model.addAttribute("situationList",situationList);

        logger.info(gson.toJson(group));

        return "GroupMsg";

    }

    /**
     * TODO 这只是一个测试显示页，到时候删除
     * @return
     */
    @RequestMapping(value = "/showCreation", method = RequestMethod.GET)
    public String viewGroupCreation() {
        return "group/createGroup";
    }

    /**
     *参数单独给出，而不给对象，怕用户直接猜后端实体类属性，然后直接拼过来。
     * @param groupName
     * @param groupContact
     * @param groupAddress
     * @param groupType
     * @param groupDec
     * @param multipartFile
     * @return  在这里有一点非常重要的是，当我们返回的对象是json，但是我们返回的
     * 实际对象里面没有get和set方法是要报406异常的。
     */
    @RequestMapping(value = "/creation", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonData createGroup(String groupName, String groupContact, String groupAddress,
                              int groupType, String groupDec, @RequestParam("checkFile") MultipartFile multipartFile) {
        try {
            Group result = groupService.createGroup(new Group(null,groupName,groupDec,groupContact,groupAddress,
            groupType,1,0,0,0,null), multipartFile);
            return new JsonData(true, result, GroupStatusInfo.CREATE_GROUP_SUCCESS.getMessage());
        } catch (EmptyFileException e) {
            return new JsonData(false, FileStatusInfo.EMPTY_FILE.getMessage());
        } catch (FormatNotMatchException e) {
            return new JsonData(false, FileStatusInfo.FORMAT_NOT_MATCH.getMessage());
        } catch (SizeBeyondException e) {
            return new JsonData(false, FileStatusInfo.SIZE_BEYOND.getMessage());
        } catch (IllegalArgumentException e) {
            return new JsonData(false,e.getMessage());
        } catch (GroupRepeatException e) {
            return new JsonData(false, GroupStatusInfo.GROUP_REPEAT.getMessage());
        } catch (CreateGroupException e) {
            //其它的异常（比如sqlException）我们统一返回创建失败这种提示信息。
            return new JsonData(false, GroupStatusInfo.CREATE_GROUP_FAIL.getMessage());
        }
    }

}
