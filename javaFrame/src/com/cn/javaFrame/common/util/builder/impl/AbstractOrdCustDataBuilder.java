package com.cn.javaFrame.common.util.builder.impl;


import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.interfaces.OrdCustDataBuilder;

/**
 * @author zhunb3
 *
 */
public abstract class AbstractOrdCustDataBuilder implements OrdCustDataBuilder{
	private String custOrderId;
	private Timestamp createDate;
	private Integer state;
	
	public String getCustOrderId() {
		return custOrderId;
	}
	public OrdCustDataBuilder setCustOrderId(String custOrderId) {
		this.custOrderId = custOrderId;
		return this;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public OrdCustDataBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}
	public Integer getState() {
		return state;
	}
	public OrdCustDataBuilder setState(Integer state) {
		this.state = state;
		return this;
	}
}
	