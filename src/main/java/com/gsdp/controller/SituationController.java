package com.gsdp.controller;

import com.gsdp.entity.group.Situation;
import com.gsdp.service.SituationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getSituationList(Model model) {

        List<Situation> situationList = situationService.getSituationMessage(0,0,0,null,true);

        List<Situation> newestSituationList = situationService.getSituationMessage(0,0,10,"publishTime",true);

        List<Situation> hottestSituationList = situationService.getSituationMessage(0,0,10,"visitors",true);

        model.addAttribute("situationList",situationList);
        model.addAttribute("newestSituationList",newestSituationList);
        model.addAttribute("hottestSituationList",hottestSituationList);

        return "situationList";
    }

    @RequestMapping("/{situationId}/detail")
    public String getSituationMsg(@PathVariable("situationId") int situationId, Model model){

        Situation situation = situationService.getSingleSituationMessage(situationId,0,5);

        System.out.println(situation);

        List<Situation> moreSituationList = situationService.getSituationMessage(0,0,10,"visitors",true);

        System.out.println(moreSituationList.size());

        model.addAttribute("situation",situation);

        model.addAttribute("moreSituationList",moreSituationList);

        return "situationMsg";
    }

    @RequestMapping(value = "/createSituation", method = RequestMethod.GET)
    public String viewCreateSituation() {
        return "createSituation";
    }
}
