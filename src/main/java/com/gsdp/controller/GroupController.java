package com.gsdp.controller;

import com.google.gson.Gson;
import com.gsdp.dao.ActivityDao;
import com.gsdp.dao.SituationDao;
import com.gsdp.entity.group.Activity;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.group.Situation;
import com.gsdp.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private ActivityDao activityDao;

    @Autowired
    private SituationDao situationDao;

    @RequestMapping(value = "/list")
    public String getGroupListMsg(Model model){

        logger.info("获取所有组织列表");

        List<Group> groupList = groupService.getAllGroupListMsg();

        Gson gson = new Gson();

        logger.info(gson.toJson(groupList));

        model.addAttribute("groupList",groupList);

        return "GroupList";
    }

    @RequestMapping(value = "/{typeId}/list")
    public String getGroupListMsg(@PathVariable("typeId") int typeId, Model model){

        logger.info("获取组织列表");

        List<Group> groupList = groupService.getGroupListMsg(typeId);

        Gson gson = new Gson();

        logger.info(gson.toJson(groupList));

        model.addAttribute("groupList",groupList);

        return "GroupList";
    }

    @RequestMapping(value = "/{groupId}/detail")
    public String getGroupDetatilMsg(@PathVariable("groupId") int groupId,Model model){

        logger.info("获取组织详细信息");

        Group group = groupService.getGroupMsg(groupId);

        List<Activity> activityList = activityDao.getActivityMessage(groupId);

       /* List<Situation> situationList =

        model.addAttribute("group",group);*/

        logger.info(gson.toJson(group));

        return "GroupMsg";

    }


}
