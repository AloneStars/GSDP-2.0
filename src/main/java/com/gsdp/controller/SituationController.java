package com.gsdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yizijun on 2016/10/31 0031.
 */
@Controller
@RequestMapping("/situation")
public class SituationController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewSituationList() {
        return "situationList";
    }
}
