package com.gsdp.controller;

import com.gsdp.dto.JsonData;
import com.gsdp.entity.group.Reply;
import com.gsdp.entity.user.User;
import com.gsdp.enums.Reply.ReplyStatusInfo;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.service.ReplyService;
import com.gsdp.util.DateUtil;
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
 * +你见到的这个玩意儿,就是吾在 2016/11/28 创造的作品
 * ********************************************************
 * +描述:回复相关的controller
 *********************************************************/
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/creation",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonData addReply(int situationId, String replyContent, HttpSession session){

        User user = (User) session.getAttribute("user");
        if(user == null)
            return new JsonData(false, ReplyStatusInfo.REPLY_NOT_LOGIN.getMessage());
        else{
            try {
                Reply reply = new Reply(replyContent, user.getUserId(), DateUtil.getDataString(), situationId, user);
                if(replyService.addReply(reply))
                    return new JsonData(false,ReplyStatusInfo.REPLY_CREATE_SUCCESS.getMessage());
                else
                    return  new JsonData(false,ReplyStatusInfo.REPLY_CREATE_FAILURE.getMessage());
            }catch (SqlActionWrongException e){
                return  new JsonData(false,ReplyStatusInfo.REPLY_CREATE_FAILURE.getMessage());
            }
        }
    }
}
