package com.gsdp.controller;

import com.gsdp.entity.group.Activity;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.group.Notice;
import com.gsdp.entity.group.Situation;
import com.gsdp.entity.user.User;
import com.gsdp.service.ActivityService;
import com.gsdp.service.GroupService;
import com.gsdp.service.NoticeService;
import com.gsdp.service.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/12/1 创造的作品
 * ********************************************************
 * +描述:关于个人中心的controller
 *********************************************************/
@RequestMapping("/personal")
@Controller
public class PersonalController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SituationService situationService;

    @Autowired
    private NoticeService noticeService;


    // TODO: 2016/12/4 活动和通知的前提都必须是该用户发布的，资源暂时不考虑，但是权限限制应该和活动一样

    // TODO: 2016/12/4 本人的视角
    // 团队，创建的团队，加入的团队 ;
    // 活动，所有的活动;
    // 动态，所有的动态;
    // 通知，所有的通知，发布的，接收的。
    // 消息，所有收到的消息

    // TODO: 2016/12/4 团友的视角
    // 团队，创建的团队，加入的团队 ;
    // 活动，所有的公开活动,相同社团的私有活动;
    // 动态，所有的动态;
    // 通知，看不到通知。
    // 消息，看不到消息。

    // TODO: 2016/12/4 陌生人视角
    // 团队，创建的团队，加入的团队 ;
    // 活动，所有的公开活动;
    // 动态，所有的动态;
    // 通知，看不到通知。
    // 消息，看不到消息。


    @RequestMapping("/{userId}/msg")
    public String personalMsg(@PathVariable("userId") int userId,Model model,HttpSession session){

        User user = (User)session.getAttribute("user");
        
        int actionUserId = user.getUserId();

        //获取组织信息
        List<Group> createdGroupList = groupService.getGroupListBySponsor(user.getUserId());

        List<Group> joinedGroupList = groupService.getGroupListByMember(user.getUserId());

        //获取动态信息
        List<Situation> situationList = situationService.getSituationListByPublisher(user.getUserId());

        model.addAttribute("createdGroupList",createdGroupList);
        model.addAttribute("joinedGroupList",joinedGroupList);
        model.addAttribute("situationList",situationList);
        
        if(userId == actionUserId ){
            // TODO: 2016/12/6 本人身份验证成功
            System.out.println("本人身份验证成功");
            //获取活动信息
            List<Activity> activityList = activityService.getGeneralActivityMessage(user.getUserId(),0,0,"publishTime",true);
            model.addAttribute("activityList",activityList);
            //获取资源信息

            //获取通知信息

            //获取消息信息

        }else{
            List<Activity> activityList = activityService.getOpenActivityMessage(user.getUserId(),0,0,"publishTime",true);
            model.addAttribute("activityList",activityList);
        }

        return "personal";
        
    }

    @RequestMapping("/organization")
    public String PersonalOrganization(HttpSession session,Model model){

        User user = (User)session.getAttribute("user");

        List<Group> createdGroupList = groupService.getGroupListBySponsor(user.getUserId());

        List<Group> joinedGroupList = groupService.getGroupListByMember(user.getUserId());

        model.addAttribute("createdGroupList",createdGroupList);
        model.addAttribute("joinedGroupList",joinedGroupList);

        return "personal";
    }

    @RequestMapping("/activity")
    public String PersonalActivity(HttpSession session,Model model){

        User user = (User)session.getAttribute("user");

        // TODO: 2016/12/4 私有活动只有和他在同一个组织的人可以看到 
        List<Activity> activityList = activityService.getGeneralActivityMessage(user.getUserId(),0,0,"publishTime",true);

        // TODO: 2016/12/4 公开活动所有人都能看到 
        List<Activity> openActivitylist = activityService.getOpenActivityMessage(user.getUserId(),0,0,"publishTime",true);

        return "personal";
    }

    @RequestMapping("/situation")
    public String PersonalSituation(HttpSession session,Model model){

        User user = (User)session.getAttribute("user");

        List<Situation> situationList = situationService.getSituationListByPublisher(user.getUserId());

        return "personal";
    }

    @RequestMapping("/notice")
    public String PersonalNotice(HttpSession session,Model model){

        User user = (User)session.getAttribute("user");

        // TODO: 2016/12/4 该用户发布的通知 ，和他在同一个组织的人进来可以看到

        // TODO: 2016/12/4 该用户收到的通知 ，只有自己能够看到

        return "personal";
    }


}
