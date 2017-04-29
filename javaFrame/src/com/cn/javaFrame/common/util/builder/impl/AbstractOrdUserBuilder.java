package com.cn.javaFrame.common.util.builder.impl;

import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.interfaces.OrdUserBuilder;


public abstract class AbstractOrdUserBuilder implements OrdUserBuilder{
	private String userOrderId;
	private Timestamp createDate;
	private Integer state;
	public String getUserOrderId() {
		return userOrderId;
	}
	public OrdUserBuilder setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
		return this;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public OrdUserBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}
	public Integer getState() {
		return state;
	}
	public OrdUserBuilder setState(Integer state) {
		this.state = state;
		return this;
	}
}
