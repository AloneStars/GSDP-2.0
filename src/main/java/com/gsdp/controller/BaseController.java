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
     * TODO 这里只是做了一个跳转，并没有做相关的查询数据操作
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewIndex(Model model) {

        List<Activity> activityList = activityService.getOpenActivityMessage(0,0,20,"publishTime",true);
        List<Situation> situationList = situationService.getSituationMessage(0,0,10,"publishTime",true);

        model.addAttribute("activityList",activityList);
        model.addAttribute("situationList",situationList);

        return "index";
    }

}
