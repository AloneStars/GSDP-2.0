package com.gsdp.entity.group;

public class Activity {
	
	//活动Id
	private int activityId;
	
	//活动标题
	private String activityTitle; 
	
	//活动详情
	private String activityContent;
	
	//活动开始时间
	private String beginTime;
	
	//活动结束时间
	private String endTime;
	
	//活动发布者
	private int activitier;
	
	//主办方
	private int sponsor;
	
	//活动人数
	private int activityNumber;
	
	 //活动地点
	private String activityAddress;
	
	//活动发布时间
	private String publishTime;
	
	//开放权限
	private int permission;

	//活动访问人数统计
	private int visitors;

	//存储主办方对象
    private Group group;
	
	public Activity() {}

	public Activity(int activityId, String activityTitle, String activityContent, String beginTime, String endTime, int activitier, int sponsor, int activityNumber, String activityAddress, String publishTime, int permission, int visitors,Group group) {
		this(activityId,activityTitle,activityContent,beginTime,endTime,activitier,sponsor,activityNumber,activityAddress,publishTime,permission,visitors);
		this.group = group;
	}

	public Activity(int activityId, String activityTitle, String activityContent, String beginTime, String endTime, int activitier, int sponsor, int activityNumber, String activityAddress, String publishTime, int permission, int visitors) {
		this(activityTitle,activityContent,beginTime,endTime,activitier,sponsor,activityNumber,activityAddress,publishTime,permission,visitors);
		this.activityId = activityId;
	}

	public Activity(String activityTitle, String activityContent,
					String beginTime, String endTime, int activitier, int sponsor,
					int activityNumber, String activityAddress, String publishTime,
					int permission, int visitors) {
		this.activityTitle = activityTitle;
		this.activityContent = activityContent;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.activitier = activitier;
		this.sponsor = sponsor;
		this.activityNumber = activityNumber;
		this.activityAddress = activityAddress;
		this.publishTime = publishTime;
		this.permission = permission;
		this.visitors = visitors;
	}

	//----------------------------------
	
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getActivitier() {
		return activitier;
	}

	public void setActivitier(int activitier) {
		this.activitier = activitier;
	}

	public int getSponsor() {
		return sponsor;
	}

	public void setSponsor(int sponsor) {
		this.sponsor = sponsor;
	}

	public int getActivityNumber() {
		return activityNumber;
	}

	public void setActivityNumber(int activityNumber) {
		this.activityNumber = activityNumber;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getVisitors() {
		return visitors;
	}

	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	//---------------------------------


	@Override
	public String toString() {
		return "Activity{" +
				"activitier=" + activitier +
				", activityId=" + activityId +
				", activityTitle='" + activityTitle + '\'' +
				", activityContent='" + activityContent + '\'' +
				", beginTime='" + beginTime + '\'' +
				", endTime='" + endTime + '\'' +
				", sponsor=" + sponsor +
				", activityNumber=" + activityNumber +
				", activityAddress='" + activityAddress + '\'' +
				", publishTime='" + publishTime + '\'' +
				", permission=" + permission +
				", visitors=" + visitors +
				", group=" + group +
				'}';
	}
}
