package com.cn.javaFrame.common.util.builder.interfaces;

import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.bean.OrdBusiData;


public interface OrdBusiDataBuilder {
	public OrdBusiDataBuilder setBusiOrderId(String busiOrderid);
	public OrdBusiDataBuilder setCreateDate(Timestamp createDate);
	public OrdBusiDataBuilder setState(Integer state);
	
	public OrdBusiData builder() throws Exception;
	public OrdUserBuilder ordUserBuilder() throws Exception;
}
