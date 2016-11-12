package com.gsdp.controller;

import com.gsdp.entity.group.Situation;
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
@RequestMapping("/situation")
public class SituationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SituationService situationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewSituationList(Model model) {

        List<Situation> situationList = situationService.getSituationMessage(0,0,0,null,true);

        List<Situation> newestSituationList = situationService.getSituationMessage(0,0,10,"publishTime",true);

        List<Situation> hottestSituationList = situationService.getSituationMessage(0,0,10,"visitors",true);

        model.addAttribute("situationList",situationList);
        model.addAttribute("newestSituationList",newestSituationList);
        model.addAttribute("hottestSituationList",hottestSituationList);

        return "situationList";
    }
}
