package com.gsdp.service;

import com.gsdp.entity.group.Notice;
import com.gsdp.exception.MessageSizeException;
import com.gsdp.exception.SqlActionWrongException;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/29 创造的作品
 * ********************************************************
 * +描述:通知相关的service接口类
 *********************************************************/
public interface NoticeService {

    boolean addNoticeMessage(Notice notice) throws MessageSizeException,SqlActionWrongException;

    List<Notice> getNoticeMessage(int groupId);

    Notice getSingleNoticeMessage(int noticeId);

    boolean deleteNoticeMessage(int noticeId);

}
