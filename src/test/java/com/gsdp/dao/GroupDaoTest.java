package com.gsdp.dao;

import java.util.List;

import javax.annotation.Resource;

import com.gsdp.entity.group.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsdp.entity.group.Group;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class GroupDaoTest {

	@Resource(name = "groupDao")
	private GroupDao groupDao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testAddAdmin() {
		int userId = 1;
		int groupId = 3;
		int affectRows = groupDao.addAdmin(userId, groupId);
		logger.info("影响的行数" + affectRows);
	}

	@Test
	public void testChangeMemberNumber(){
		int groupId = 3;
		int number = -1;
		int affectRows = groupDao.changeMemberNumber(number,groupId);
		logger.info("影响的行数" + affectRows);
	}
	
	@Test
	public void testDeleteAdmin() {
		int userId = 1;
		int groupId = 3;
		int affectRows = groupDao.deleteAdmin(userId, groupId);
		logger.info("影响的行数" + affectRows);
	}
	
	@Test
	public void testChangeOwner() {
		int userId = 2;
		int groupId = 3;
		int affectRows = groupDao.changeOwner(userId, groupId);
		logger.info("影响的行数:" + affectRows);
	}
	
	@Test
	public void testAddMember() {
		int userId = 2;
		int groupId = 4;
		String applyReason = "我非常想加这个社团";
		String phone = "13811111111";

		int affectRows = groupDao.addMember(new Member(userId,groupId,applyReason,phone));
		logger.info("影响的行数:" + affectRows);
	}
	
	@Test
	public void testDeleteMember() {
		int userId = 2;
		int groupId = 4;
		int affectRows = groupDao.deleteMember(userId, groupId);
		logger.info("影响的行数:" + affectRows);
	}
	
	@Test
	public void testAddGroup() {
		String groupIcon = "image/GroupIcon/ACG.jpg";
		String groupName = "高冷社团";
		String groupDec = "我们很高冷";
		String groupContact = "13811111111";
		String groupAddress = "16A-310";
		int groupType = 4;
		int owner = 2;
		int visitors = 456;
		int groupMembers = 100;
		int groupStatus = 0;
		String groupEvidence = "D:/workspace/profile/abc.doc";
		Group group = new Group(groupIcon, groupName, groupDec, groupContact, groupAddress, groupType, owner, visitors,groupMembers,groupStatus,groupEvidence);
		int affectRows = groupDao.addGroup(group);
		logger.info("影响的行数:" + affectRows + "返回的自增id为:" + group.getGroupId());
	}
	
	@Test
	public void testUpdateGroup() {
		int groupId = 8;
		String groupIcon = "image/GroupIcon/ACG.jpg";
		String groupName = "高冷社团";
		String groupDec = "我们很高冷，并且我们也很帅";
		String groupContact = "13811111111";
		String groupAddress = "16A-310";
		int groupType = 4;
		int owner = 2;
		int visitors = 111111;
		int groupMembers = 100;
		Group group = new Group(groupId,groupIcon, groupName, groupDec, groupContact, groupAddress, groupType, owner, visitors,groupMembers);
		int affectRows = groupDao.updateGroup(group);
		logger.info("影响的行数:" + affectRows);
	}
	
	@Test
	public void testGetGroupMessage() {
		int groupId = 3;
		Group group = groupDao.getGroupMessage(groupId);
		logger.info("group = {}", group);
	}
	
	@Test
	public void testGetGroupMessageByType() {
		int groupType = 1;
		List<Group> list = groupDao.getGroupMessageByType(groupType,0,0,"visitors",true);
		logger.info("list = {}", list);
	}
	
	@Test
	public void testGetAllGroupMessage() {
		List<Group> list = groupDao.getAllGroupMessage(0,0,"visitors",true);
		logger.info("list = {}", list);
	}

	@Test
	public void testGetGroupListMessageExpGroup(){

		List<Group> groupList = groupDao.getGroupListMessageExpGroup(3);

		logger.info("list = {}", groupList);
	}

	@Test
	public void isSameGroupName() throws Exception{
		String groupName = "动漫社";
		int affectRows = groupDao.isSameGroupName(groupName);
		logger.info("影响的行数:" + affectRows);
	}

	@Test
	public void getGroupAdmin() throws Exception {
		int group_id = 4;
		List<Integer> admin = groupDao.getGroupAdmin(group_id);
		logger.info("admin = {}", admin);
	}

	@Test
	public void getGroupMembersByStatus() throws Exception {
		int groupId = 3;
		List<Member> list = groupDao.getGroupMembersByStatus(groupId,0,0,100);
		logger.info("list = {}", list);
	}

	@Test
	public void getGroupAllNumberByStatus() {
		int groupId = 3;
		int status = 0;
		int numbers = groupDao.getGroupAllNumberByStatus(groupId,status);
		logger.info("numbers = " + numbers);
	}

	@Test
	public void updateMember() throws Exception {
		int userId = 2;
		int groupId = 3;
		int status = 1;
		int affectRows = groupDao.updateMember(new Member(userId,groupId,status));
		logger.info("影响的行数:" + affectRows);
	}
}
