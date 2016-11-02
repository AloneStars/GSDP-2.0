package com.gsdp.service.impl;

import com.gsdp.dao.GroupDao;
import com.gsdp.entity.group.Group;
import com.gsdp.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/31 创造的作品
 * ********************************************************
 * +描述:GroupService实现类
 *********************************************************/
@Service
public class GroupServiceImpl implements GroupService{

    private final Logger looger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public GroupDao groupDao;

    @Override
    public List<Group> getGroupListMsg(int typeId) {

        List<Group> groupList = groupDao.getGroupMessageByType(typeId);

        return groupList;
    }

    @Override
    public Group getGroupMsg(int groupId) {

        Group group = groupDao.getGroupMessage(groupId);

        return group;

    }

    @Override
    public List<Group> getAllGroupListMsg() {

        List<Group> groupList = groupDao.getAllGroupMessage();

        return groupList;

    }

    @Override
    public boolean addGroup(Group group) {

        int number = groupDao.addGroup(group);

        if(number == 1) {
            looger.info("数据库插入组织成功");
            return true;
        }
        else {
            looger.info("数据库插入组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delGroup(int groupId) {

        int number = groupDao.deleteGroup(groupId);

        if(number == 1) {
            looger.info("数据库删除组织成功");
            return true;
        }
        else {
            looger.info("数据库删除组织数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean updateGroup(Group group) {

        int number = groupDao.updateGroup(group);

        if(number == 1) {
            looger.info("数据库更新组织成功");
            return true;
        }
        else {
            looger.info("数据库更新组织数量:{}", number);
            return false;
        }
    }

    @Override
    public boolean addAdmin(int userId, int groupId) {

        int number = groupDao.addAdmin(userId,groupId);

        if(number == 1) {
            looger.info("数据库添加组织管理员成功");
            return true;
        }
        else {
            looger.info("数据库添加组织管理员数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean delAdmin(int userId, int groupId) {

        int number = groupDao.deleteAdmin(userId,groupId);

        if(number == 1) {
            looger.info("数据库删除组织管理员成功");
            return true;
        }
        else {
            looger.info("数据库删除组织管理员数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean addMember(int userId, int groupId) {

        int number = groupDao.addMember(userId, groupId);
        int anoNumber = groupDao.changeMemberNumber(1,groupId);

        if((number == 1 )&& (anoNumber ==1)) {
            looger.info("数据库添加组织成员成功");
            return true;
        }
        else {
            looger.info("数据库添加组织成员数量:{}", number);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteMember(int userId, int groupId) {

        int number = groupDao.deleteMember(userId, groupId);
        int anoNumber = groupDao.changeMemberNumber(-1,groupId);

        if((number == 1 )&& (anoNumber ==1)) {
            looger.info("数据库删除组织成员成功");
            return true;
        }
        else {
            looger.info("数据库删除组织成员数量:{}", number);
            return false;
        }

    }

    @Override
    public boolean changeOwner(int userId, int groupId) {

        int number = groupDao.changeOwner(userId, groupId);

        if(number == 1) {
            looger.info("数据库转让组织成功");
            return true;
        }
        else {
            looger.info("数据库转让组织数量:{}", number);
            return false;
        }
    }
}
