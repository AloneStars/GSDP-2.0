package com.gsdp.service.impl;

import com.gsdp.dao.ReplyDao;
import com.gsdp.entity.group.Reply;
import com.gsdp.exception.MessageSizeException;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/28 创造的作品
 * ********************************************************
 * +描述:回复相关的回复服务类
 *********************************************************/
@Service
public class ReplyServiceImpl implements ReplyService {


    @Autowired
    private ReplyDao replyDao;

    @Override
    public boolean addReply(Reply reply) throws SqlActionWrongException,MessageSizeException{

        int length = reply.getReplyContent().length();
        if(length>=200 || length<=0){
            throw new MessageSizeException("message size is incorrect");
        }else {
            int affectRows = replyDao.addReply(reply);

            if (affectRows == 1)
                return true;
            else
                throw new SqlActionWrongException("Add reply failure");
        }

    }

}
