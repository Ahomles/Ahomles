package com.cn.javaFrame.common.util.builder.bean;

import java.sql.Timestamp;


public class OrdBusi {
	private String busiOrderId;
	private Timestamp createDate;
	private Integer state;
	public String getBusiOrderId() {
		return busiOrderId;
	}
	public void setBusiOrderId(String busiOrderId) {
		this.busiOrderId = busiOrderId;
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
