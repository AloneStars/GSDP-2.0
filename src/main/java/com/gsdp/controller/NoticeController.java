package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.entity.group.Notice;
import com.gsdp.entity.user.User;
import com.gsdp.enums.notice.NoticeStatusInfo;
import com.gsdp.exception.MessageSizeException;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.service.NoticeService;
import com.gsdp.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/29 创造的作品
 * ********************************************************
 * +描述:通知相关的controller
 *********************************************************/
@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/creation",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonData addNotice(String noticeContent, int groupId, HttpSession session){

        User user = (User)session.getAttribute("user");

        Notice notice = new Notice(noticeContent, DateUtil.getDataString(),user.getUserId(),groupId);

        try {
            if(noticeService.addNoticeMessage(notice))
                return new JsonData(true,NoticeStatusInfo.NOTICE_CREATE_SUCCESS.getMessage());
            else
                return  new JsonData(false,NoticeStatusInfo.NOTICE_CREATE_FAILURE.getMessage());
        }catch (MessageSizeException e){
            return  new JsonData(false,NoticeStatusInfo.NOTICE_MESSAGESIZE_INCORRECT.getMessage());
        } catch(SqlActionWrongException e){
            return  new JsonData(false,NoticeStatusInfo.NOTICE_CREATE_FAILURE.getMessage());
        }

    }
}
