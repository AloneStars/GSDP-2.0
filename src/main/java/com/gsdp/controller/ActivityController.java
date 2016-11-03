package com.gsdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yizijun on 2016/10/31 0031.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    /**
     * 跳转到活动列表页，activityList.jsp
     * TODO 并没有做相关数据的获得
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewActivityList() {
        return "activityList";
    }

}
