package com.cn.javaFrame.common.util.builder.impl;

import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.interfaces.OrdBusiDataBuilder;
import com.cn.javaFrame.common.util.builder.interfaces.OrdUserBuilder;

public abstract class AbstractOrdBusiDataBuilder implements OrdBusiDataBuilder{
	private String busiOrderId;
	private Timestamp createDate;
	private Integer state;
	public String getBusiOrderId() {
		return busiOrderId;
	}
	public OrdBusiDataBuilder setBusiOrderId(String busiOrderId) {
		this.busiOrderId = busiOrderId;
		return this;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public OrdBusiDataBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}
	public Integer getState() {
		return state;
	}
	public OrdBusiDataBuilder setState(Integer state) {
		this.state = state;
		return this;
	}
}
