package com.mi.group.model.vo;

public class Group {
	private String groupId;
	private String groupName;
	private String groupCaptin;
	
	public Group() {
		// TODO Auto-generated constructor stub
	}

	public Group(String groupId, String groupName, String groupCaptin) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupCaptin = groupCaptin;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupCaptin() {
		return groupCaptin;
	}

	public void setGroupCaptin(String groupCaptin) {
		this.groupCaptin = groupCaptin;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", groupCaptin=" + groupCaptin + "]";
	}
	
}
