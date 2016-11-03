package com.gsdp.entity.group;

public class Resource{
	
	//文件Id
	private int resourceId;
	
	//文件类型
	private int resourceType;
	
	//文件名
	private String resourceName;
	
	//文件地址
	private String resourceSrc;
	
	//上传人
	private int updater;    
	
	//上传时间
	private String updateTime;
	
	//文件上传到那个组织
	private int groupId;
	
	//浏览权限，只对团体内成员开放，还是对所有人开放
	private int permission;

    public Resource(){}

	public Resource(String resourceName, String resourceSrc, int resourceType, int updater, String updateTime, int groupId, int permission) {
		this.groupId = groupId;
		this.permission = permission;
		this.resourceName = resourceName;
		this.resourceSrc = resourceSrc;
		this.resourceType = resourceType;
		this.updater = updater;
		this.updateTime = updateTime;
	}

	public Resource( int resourceId,String resourceName, String resourceSrc, int resourceType, int updater, String updateTime, int groupId, int permission) {
        this(resourceName,resourceSrc,resourceType,updater,updateTime,groupId,permission);
		this.resourceId = resourceId;
	}

	//---------------------------

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

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceSrc() {
		return resourceSrc;
	}

	public void setResourceSrc(String resourceSrc) {
		this.resourceSrc = resourceSrc;
	}

	public int getResourceType() {
		return resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
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

	//----------------------

	@Override
	public String toString() {
		return "Resource{" +
				"groupId=" + groupId +
				", resourceId=" + resourceId +
				", resourceType=" + resourceType +
				", resourceName='" + resourceName + '\'' +
				", resourceSrc='" + resourceSrc + '\'' +
				", updater=" + updater +
				", updateTime='" + updateTime + '\'' +
				", permission=" + permission +
				'}';
	}
}
