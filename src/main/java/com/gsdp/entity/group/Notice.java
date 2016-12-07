package com.gsdp.entity.group;


public class Notice {
	
	//通知Id
	private int noticeId;  
	
	//通知内容
	private String noticeContent;
	
	//通知发起的时间
	private String noticeTime;
	
	//通知发起者
	private int noticer;
	
	//通知发布到那个组织
	private int groupId;

	//存储组织信息
	private Group group;

	public Notice() {}

	public Notice(Group group,int noticeId, String noticeContent, String noticeTime, int noticer, int groupId){
		this(noticeId,noticeContent,noticeTime,noticer,groupId);
		this.group = group;
	}

	public Notice(int noticeId, String noticeContent, String noticeTime, int noticer, int groupId) {
		this(noticeContent,noticeTime,noticer,groupId);
		this.noticeId = noticeId;
	}

	public Notice(String noticeContent, String noticeTime, int noticer,
				  int groupId) {
		this.noticeContent = noticeContent;
		this.noticeTime = noticeTime;
		this.noticer = noticer;
		this.groupId = groupId;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public int getNoticer() {
		return noticer;
	}

	public void setNoticer(int noticer) {
		this.noticer = noticer;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Notice{" +
				"group=" + group +
				", noticeId=" + noticeId +
				", noticeContent='" + noticeContent + '\'' +
				", noticeTime='" + noticeTime + '\'' +
				", noticer=" + noticer +
				", groupId=" + groupId +
				'}';
	}
}
