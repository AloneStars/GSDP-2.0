package com.gsdp.controller;

import com.gsdp.entity.group.Activity;
import com.gsdp.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/list")
    public String getActivityListMsg(Model model){

        logger.info("获取活动列表");
        List<Activity> activityList = activityService.getAllActivity();
        logger.info("获取最新活动列表");
        List<Activity> newestActivityList = activityService.getGeneralActivityMessage(0,0,10,"publishTime",true);
        logger.info("获取最热活动列表");
        List<Activity> hottestActivityList = activityService.getGeneralActivityMessage(0,0,10,"visitors",true);

        model.addAttribute("activityList",activityList);
        model.addAttribute("newestActivityList",newestActivityList);
        model.addAttribute("hottestActivityList",hottestActivityList);

        return "activityList";
    }
}
