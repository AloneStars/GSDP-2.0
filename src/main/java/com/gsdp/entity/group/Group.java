package com.gsdp.entity.group;

import com.gsdp.entity.user.User;

public class Group {
    
	//团体Id
	private int groupId;
	
	//团体标志
	private String groupIcon;
	
	//团体名称
	private String groupName;
	
	//团体介绍
	private String groupDec;
	
	//团队联系方式
	private String groupContact;
	
	//团体办公地点
	private String groupAddress;
	
	//团体所属类型
	private int groupType;
	
	//团体创建者
	private int owner;

	//社团访问人数统计
	private int visitors;

	//社团成员数量
	private int groupMembers;

	//团队状态
	private int groupStatus;

	//团队法人
	private User groupOwner;


	//团队佐证材料存放地址
	private String groupEvidence;
	
	public Group() {}

	public Group(String groupIcon, String groupName, String groupDec, String groupContact, String groupAddress, int groupType, int owner, int visitors, int groupMembers, int groupStatus, String groupEvidence) {
		this(groupIcon, groupName, groupDec, groupContact, groupAddress, groupType, owner, visitors, groupMembers);
		this.groupStatus = groupStatus;
		this.groupEvidence = groupEvidence;
	}

	public Group(int groupId, String groupIcon, String groupName, String groupDec, String groupContact, String groupAddress, int groupType, int owner, int visitors, int groupMembers) {
		this(groupIcon, groupName, groupDec, groupContact, groupAddress, groupType, owner, visitors, groupMembers);
		this.groupId = groupId;
	}

	public Group(int groupId, String groupName, String groupDec, String groupContact, String groupAddress, int groupType) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDec = groupDec;
		this.groupContact = groupContact;
		this.groupAddress = groupAddress;
		this.groupType = groupType;
	}

	public Group(String groupName, String groupDec, String groupContact, String groupAddress, int groupType, int owner, int groupMembers, int groupStatus) {
		this.groupName = groupName;
		this.groupDec = groupDec;
		this.groupContact = groupContact;
		this.groupAddress = groupAddress;
		this.groupType = groupType;
		this.owner = owner;
		this.groupMembers = groupMembers;
		this.groupStatus = groupStatus;
	}

	public Group(String groupIcon, String groupName, String groupDec,
				 String groupContact, String groupAddress, int groupType, int owner, int visitors, int groupMembers) {
		this.groupIcon = groupIcon;
		this.groupName = groupName;
		this.groupDec = groupDec;
		this.groupContact = groupContact;
		this.groupAddress = groupAddress;
		this.groupType = groupType;
		this.owner = owner;
		this.visitors = visitors;
		this.groupMembers = groupMembers;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupIcon() {
		return groupIcon;
	}

	public void setGroupIcon(String groupIcon) {
		this.groupIcon = groupIcon;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDec() {
		return groupDec;
	}

	public void setGroupDec(String groupDec) {
		this.groupDec = groupDec;
	}

	public String getGroupContact() {
		return groupContact;
	}

	public void setGroupContact(String groupContact) {
		this.groupContact = groupContact;
	}

	public String getGroupAddress() {
		return groupAddress;
	}

	public void setGroupAddress(String groupAddress) {
		this.groupAddress = groupAddress;
	}

	public int getGroupType() {
		return groupType;
	}

	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getVisitors() {
		return visitors;
	}

	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}

	public int getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(int groupMembers) {
		this.groupMembers = groupMembers;
	}

	public int getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(int groupStatus) {
		this.groupStatus = groupStatus;
	}

	public String getGroupEvidence() {
		return groupEvidence;
	}

	public void setGroupEvidence(String groupEvidence) {
		this.groupEvidence = groupEvidence;
	}

	public User getGroupOwner() {
		return groupOwner;
	}

	public void setGroupOwner(User groupOwner) {
		this.groupOwner = groupOwner;
	}

	@Override
	public String toString() {
		return "Group{" +
				"groupId=" + groupId +
				", groupIcon='" + groupIcon + '\'' +
				", groupName='" + groupName + '\'' +
				", groupDec='" + groupDec + '\'' +
				", groupContact='" + groupContact + '\'' +
				", groupAddress='" + groupAddress + '\'' +
				", groupType=" + groupType +
				", owner=" + owner +
				", visitors=" + visitors +
				", groupMembers=" + groupMembers +
				", groupStatus=" + groupStatus +
				", groupOwner=" + groupOwner +
				", groupEvidence='" + groupEvidence + '\'' +
				'}';
	}
}
