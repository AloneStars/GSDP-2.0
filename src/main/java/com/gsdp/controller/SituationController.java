package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.dto.Pagination;
import com.gsdp.entity.group.Situation;
import com.gsdp.enums.pagination.PaginationStatusInfo;
import com.gsdp.entity.user.User;
import com.gsdp.enums.BaseStatusInfo;
import com.gsdp.enums.situation.SituationStatusInfo;
import com.gsdp.exception.situation.SituationException;
import com.gsdp.service.SituationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

        List<Situation> situations = situationService.getSituationMessage(0,0,0,null,true);

        int showData = 3;

        int totalPage = 0;

        if(situations.size()%showData == 0)
            totalPage = situations.size()/showData;
        else
            totalPage = (situations.size()/showData)+1;

        Pagination pagination = new Pagination(totalPage,1,showData);

        List<Situation> situationList = situationService.getSituationMessage(0,(pagination.getCurrentPage()-1)*showData,showData,null,true);

        List<Situation> newestSituationList = situationService.getSituationMessage(0,0,10,"publishTime",true);

        List<Situation> hottestSituationList = situationService.getSituationMessage(0,0,10,"visitors",true);

        model.addAttribute("situationList",situationList);
        model.addAttribute("newestSituationList",newestSituationList);
        model.addAttribute("hottestSituationList",hottestSituationList);
        model.addAttribute("pagination",pagination);

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

    @RequestMapping(value = "/situationCreation", method = RequestMethod.POST,
    produces = "application/json; charset=utf-8")
    @ResponseBody
   public JsonData createSituation(String situationTitle, String situationContent, int groupId,
                                   HttpSession session) {

        User user = (User)session.getAttribute("user");
        int userId = user.getUserId();
        try {
            Integer situationId = situationService.publishSituation(userId, groupId, situationTitle, situationContent);
            if(null != situationId) {
                return new JsonData(true, situationId, SituationStatusInfo.PUBLISH_SITUATION_SUCCESS.getMessage());
            } else {
                return new JsonData(false, SituationStatusInfo.PUBLISH_SITUATION_FAIL.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return new JsonData(false, BaseStatusInfo.PARAMETER_ERROR.getMessage());
        } catch (SituationException e) {
            return new JsonData(false, BaseStatusInfo.SERVER_INTERNAL_ERROR.getMessage());
        }
   }

    @RequestMapping(value = "/pagination", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonData getPaginationActivity(int currentPage, int showData){

        List<Situation> situationList = situationService.getSituationMessage(0,(currentPage-1)*showData,showData,null,true);

        return new JsonData(true,situationList, PaginationStatusInfo.PAGINATION_SUCCESS.getMessage());
    }
}
