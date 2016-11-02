package com.gsdp.entity.group;

public class File {
	
	//文件Id
	private int fileId;  
	
	//文件类型
	private int fileType;
	
	//文件名
	private String fileName;
	
	//文件地址
	private String fileSrc;
	
	//上传人
	private int updater;    
	
	//上传时间
	private String updateTime;
	
	//文件上传到那个组织
	private int groupId;
	
	//浏览权限，只对团体内成员开放，还是对所有人开放
	private int permission;

	public File(){}

	public File(String fileName, String fileSrc, int fileType, int groupId, int permission, int updater, String updateTime,int... fileId) {
		this.fileName = fileName;
		this.fileSrc = fileSrc;
		this.fileType = fileType;
		this.groupId = groupId;
		this.permission = permission;
		this.updater = updater;
		this.updateTime = updateTime;
		if(fileId.length == 1)
			this.fileId = fileId[0];
	}

	//---------------------------

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public int getUpdater() {
		return updater;
	}

	public void setUpdater(int updater) {
		this.updater = updater;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	//----------------------

	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", fileType=" + fileType
				+ ", fileName=" + fileName + ", fileSrc=" + fileSrc
				+ ", updater=" + updater + ", updateTime=" + updateTime
				+ ", groupId=" + groupId + ", permission=" + permission + "]";
	}
	
}
