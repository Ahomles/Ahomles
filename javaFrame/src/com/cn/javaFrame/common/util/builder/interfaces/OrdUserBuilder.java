package com.cn.javaFrame.common.util.builder.interfaces;

import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.bean.OrdUser;

public interface OrdUserBuilder {
	public OrdUserBuilder setUserOrderId(String userOrderId);
	public OrdUserBuilder setCreateDate(Timestamp createDate);
	public OrdUserBuilder setState(Integer state);
	public OrdUser builder();
}
