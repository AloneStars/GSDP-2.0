package com.gsdp.service.impl;

import com.gsdp.dao.NoticeDao;
import com.gsdp.email.Send;
import com.gsdp.entity.group.Group;
import com.gsdp.entity.group.Notice;
import com.gsdp.entity.user.User;
import com.gsdp.exception.EmailSendException;
import com.gsdp.exception.MessageSizeException;
import com.gsdp.exception.SqlActionWrongException;
import com.gsdp.service.GroupService;
import com.gsdp.service.NoticeService;
import com.gsdp.service.UserService;
import com.gsdp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Override
    @Transactional
    public boolean addNoticeMessage(Notice notice) throws MessageSizeException,SqlActionWrongException{

        int length = notice.getNoticeContent().length();

        if(length>=200 || length<=0){
            throw new MessageSizeException("message size is incorrect");
        }else {
            int affectRows = noticeDao.addNoticeMessage(notice);

            if (affectRows == 1){

                int groupId = notice.getGroupId();
                Group group = groupService.getGroupMsg(groupId);
                List<User> userList = userService.getUserListByGroupId(groupId);
                Send send = new Send("/email.properties");

                for (User user: userList) {

                     boolean success = send.email(user.getLoginEmail(),"本邮件为GSDP(校园团体风采展示平台)的组织通知邮件",
                            "<h1>"+group.getGroupName()+"的管理员:"+user.getUsername()+"在"+DateUtil.getDataString()+"发布通知"
                                    +"<br>通知类容如下:"+notice.getNoticeContent()+"<br>请注意查收通知</h1>");

                    if(success)
                        continue;
                    else
                        return false;

                }

                return true;
            }
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
