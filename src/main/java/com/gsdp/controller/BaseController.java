package com.gsdp.controller;

import com.gsdp.entity.group.Activity;
import com.gsdp.entity.group.Situation;
import com.gsdp.service.ActivityService;
import com.gsdp.service.SituationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yizijun on 2016/10/31 0031.
 */
@Controller
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SituationService situationService;

    /**
     * 当直接访问我们项目的根目录，直接跳转到index.jsp
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewIndex(Model model) {

        List<Activity> activityList = activityService.getGeneralActivityMessage(0,0,20,"publishTime",true);
        List<Situation> situationList = situationService.getSituationMessage(0,0,10,"publishTime",true);

        model.addAttribute("activityList",activityList);
        model.addAttribute("situationList",situationList);

        return "index";
    }

    //权限错误显示页
    @RequestMapping(value = "/authorityError")
    public String viewAuthorityErrorPage() {
        return "errorPage/authorityError";
    }

    //显示404错误的页面
    @RequestMapping(value = "/pageNotFoundError")
    public String viewPageNotFoundErrorPage() {
        return "errorPage/pageNotFoundError";
    }

    //显示500错误的页面


    //显示406参数错误的页面

}
