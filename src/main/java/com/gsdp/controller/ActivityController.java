package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.entity.group.Activity;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.user.User;
import com.gsdp.service.ActivityService;
import com.gsdp.service.GroupService;
import com.gsdp.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/3 创造的作品
 * ********************************************************
 * +描述:活动相关的控制类
 *********************************************************/
@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ActivityService activityService;

    @Autowired
    public GroupService groupService;

    @RequestMapping("/list")
    public String getActivityListMsg(Model model){

        logger.info("获取活动列表");
        List<Activity> activityList = activityService.getAllOpenActivity();
        logger.info("获取最新活动列表");
        List<Activity> newestActivityList = activityService.getOpenActivityMessage(0,0,10,"publishTime",true);
        logger.info("获取最热活动列表");
        List<Activity> hottestActivityList = activityService.getOpenActivityMessage(0,0,10,"visitors",true);

        model.addAttribute("activityList",activityList);
        model.addAttribute("newestActivityList",newestActivityList);
        model.addAttribute("hottestActivityList",hottestActivityList);

        return "activityList";
    }

    @RequestMapping("/{activityId}/detail")
    public String getActivityMsg(@PathVariable("activityId") int activityId,Model model){

        Activity activity = activityService.getSingleActivity(activityId);

        Group group = groupService.getGroupMsg(activity.getSponsor());

        System.out.println(group);

        List<Activity> moreActivityList = activityService.getGeneralActivityMessage(0,0,10,"visitors",true);

        model.addAttribute("activity",activity);

        model.addAttribute("group",group);

        model.addAttribute("moreActivityList",moreActivityList);

        return "activityMsg";
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonData addActivity(String activityName, int open, String startTime,
                                String endTime, int activityNumber, String location,
                                String content,int groupId,HttpSession session){

        System.out.print(new Date().toString());

        User user = (User)session.getAttribute("user");

        Activity activity = new Activity(activityName,content,startTime,endTime,user.getUserId(),groupId,activityNumber,location, DateUtil.getDataString(),open,0);

        if(activityService.addActivity(activity))
            return new JsonData(true,"活动发布成功");
        else
            return new JsonData(true,"数据库插入错误");
    }
}
