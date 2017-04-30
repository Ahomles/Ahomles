package com.cn.javaFrame.common.util.proxy.Test;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
	private long userId;
	private String name;
	private Timestamp createDate;
	private int state;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", createDate="
				+ createDate + ", state=" + state + "]";
	}
	
	
}
