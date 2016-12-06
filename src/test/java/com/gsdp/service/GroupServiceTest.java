package com.gsdp.service;

import com.google.gson.Gson;
import com.gsdp.dto.group.GroupMember;
import com.gsdp.dto.group.GroupMemberWithCurrentUserRole;
import com.gsdp.dto.group.MemberAddition;
import com.gsdp.entity.group.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/1 创造的作品
 * ********************************************************
 * +描述:组织服务测试类
 *********************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class GroupServiceTest {

    public final Gson gson = new Gson();

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GroupService groupService;


    @Test
    public void getGroupListMsg() throws Exception {

        int typeId = 1;

        List<Group> groupList = groupService.getGroupListMsg(typeId,0,0,"visitors",true);

        for (Group group: groupList) {
            System.out.println("人数："+group.getVisitors());
        }

        logger.info("组织信息列表{}",groupList);

    }

    @Test
    public void getGroupMsg() throws Exception {

    }

    @Test
    public void getAllGroupListMsg() throws Exception {

    }

    @Test
    public void addGroup() throws Exception {

    }

    @Test
    public void delGroup() throws Exception {

    }

    @Test
    public void updateGroup() throws Exception {

    }

    @Test
    public void addAdmin() throws Exception {
        int userId = 2;
        int groupId = 3;
        boolean result = groupService.addAdmin(userId, groupId);
        logger.info("result = " + result);
    }

    @Test
    public void deleteAdmin() throws Exception {
        int userId = 2;
        int groupId = 3;
        boolean result = groupService.deleteAdmin(userId, groupId);
        logger.info("result = " + result);
    }

    @Test
    public void addMember() throws Exception {
        int userId = 2;
        int groupId = 4;
        String applyReason = "我很想加入这个社团";
        String phone = "13811111111";
        MemberAddition memberAddition = groupService.addMember(userId,groupId,applyReason,phone);
        logger.info("memberAddition = {}" + memberAddition);
    }

    @Test
    public void changeOwner() throws Exception {
        int currentOwner = 1;
        int userId = 3;
        int groupId = 3;
        boolean result = groupService.changeOwner(currentOwner, userId, groupId);
        logger.info("result = " + result);
    }

    @Test
    public void getGroupListMessageExpGroup() throws Exception{

        List<Group> groupList =  groupService.getGroupListMessageExpGroup(3);

        logger.info("groupList={}",groupList);

    }

    @Test
    public void quitGroup() throws Exception {
        int userId = 2;
        int groupId = 3;
        boolean result = groupService.quitGroup(userId, groupId);
        logger.info("result = {}", result);
    }

    @Test
    public void getGroupMembersByStatus() throws Exception {
        int groupId = 3;
        int status = 1;
        int currentPage = -3;
        int limit = 100;
        GroupMember groupMember = groupService.getGroupMembersByStatus(groupId,status,currentPage,limit);
        logger.info("groupMember = {}", groupMember);
    }

    @Test
    public void agreeUserJoinGroup() throws Exception {
        int userId = 1;
        int groupId = 3;
        boolean result = groupService.agreeUserJoinGroup(userId, groupId);
        logger.info("result = " + result);
    }

    @Test
    public void disagreeUserJoinGroup() throws Exception {
        int userId = 3;
        int groupId = 4;
        boolean result = groupService.disagreeUserJoinGroup(userId, groupId);
        logger.info("result = " + result);
    }

    @Test
    public void getGroupMessageWithOwner() throws Exception {
        int groupId = 3;
        Group group = groupService.getGroupMessageWithOwner(groupId);
        logger.info("group = " + group);
    }

    @Test
    public void getGroupMembersWithRoleByStatus() throws Exception {
        int groupId = 3;
        int currentUserId = 66;
        int status = 1;
        int currentPage = 1;
        int limit = 100;
        GroupMemberWithCurrentUserRole groupMemberWithCurrentUserRole =
        groupService.getGroupMembersWithRoleByStatus(groupId, status, currentUserId, currentPage, limit);
        logger.info("groupMemberWithCurrentUserRole = " + groupMemberWithCurrentUserRole);
    }

    @Test
    public void fireMember() throws Exception {
        int currentUserId = 2;
        int userId = 8;
        int groupId = 3;
        boolean result = groupService.fireMember(currentUserId, userId, groupId);
        logger.error("result = " + result);
    }

    @Test
    public void getAllGroupMessagesWithOwner() throws Exception {
        List<Group> list = groupService.getAllGroupMessagesWithOwner();
        logger.info("list = {}", list);
    }

}