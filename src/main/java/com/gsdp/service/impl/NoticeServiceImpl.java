package com.gsdp.service.impl;

import com.gsdp.dao.NoticeDao;
import com.gsdp.entity.group.Notice;
import com.gsdp.exception.MessageSizeException;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/29 创造的作品
 * ********************************************************
 * +描述:通知相关的service实现类
 *********************************************************/
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public boolean addNoticeMessage(Notice notice) throws MessageSizeException,SqlActionWrongException{

        int length = notice.getNoticeContent().length();

        if(length>=200 || length<=0){
            throw new MessageSizeException("message size is incorrect");
        }else {
            int affectRows = noticeDao.addNoticeMessage(notice);

            if (affectRows == 1)
                return true;
            else
                throw new SqlActionWrongException("Add Notice failure");
        }

    }

    @Override
    public List<Notice> getNoticeMessage(int groupId) {
        return null;
    }

    @Override
    public Notice getSingleNoticeMessage(int noticeId) {
        return null;
    }

    @Override
    public boolean deleteNoticeMessage(int noticeId) {
        return false;
    }
}
