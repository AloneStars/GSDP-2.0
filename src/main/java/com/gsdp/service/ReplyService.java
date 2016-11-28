package com.gsdp.service;

import com.gsdp.dao.ReplyDao;
import com.gsdp.entity.group.Reply;
import com.gsdp.exception.SqlActionWrongException;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/28 创造的作品
 * ********************************************************
 * +描述:用户回复相关的服务接口类
 *********************************************************/
public interface ReplyService {

    boolean addReply(Reply reply) throws SqlActionWrongException;
}
