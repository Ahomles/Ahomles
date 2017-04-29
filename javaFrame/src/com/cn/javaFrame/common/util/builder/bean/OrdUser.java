package com.cn.javaFrame.common.util.builder.bean;

import java.sql.Timestamp;

public class OrdUser {
	private String userOrderId;
	private Timestamp createDate;
	private Integer state;
	public String getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
