package com.gsdp.dao;

import com.gsdp.entity.group.Reply;
import com.gsdp.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/28 创造的作品
 * ********************************************************
 * +描述:添加回复的测试类
 *********************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ReplyDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource( name = "replyDao")
    public ReplyDao replyDao ;

    @Test
    public void addReply() throws Exception {

        Reply reply = new Reply();
        reply.setReplyContent("test");
        reply.setReplyer(1);
        reply.setReplyTime(DateUtil.getDataString());
        reply.setSituationId(16);

        int affectRows = replyDao.addReply(reply);

        logger.info("影响的行数:"+affectRows+";返回自增Id:"+reply.getReplyId());

    }

}