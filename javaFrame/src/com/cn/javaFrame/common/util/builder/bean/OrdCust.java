package com.cn.javaFrame.common.util.builder.bean;

import java.sql.Timestamp;


public class OrdCust {
	private String custOrderId;
	private Timestamp createDate;
	private Integer state;
	public String getCustOrderId() {
		return custOrderId;
	}
	public void setCustOrderId(String custOrderId) {
		this.custOrderId = custOrderId;
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
