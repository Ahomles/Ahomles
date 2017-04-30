package com.cn.javaFrame.common.util.newInstance;

import java.util.ArrayList;
import java.util.List;

public class ServiceBuilder {
	private long userId;
	private String name;
	private List list=new ArrayList();
	public long getUserId() {
		return userId;
	}
	public ServiceBuilder setUserId(long userId) {
		this.userId = userId;
		return this;
	}
	public String getName() {
		return name;
	}
	public ServiceBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public List getList() {
		return list;
	}
	public ServiceBuilder setList(List list) {
		this.list = list;
		return this;
	}
	@Override
	public String toString() {
		return "ServiceBuilder [userId=" + userId + ", name=" + name
				+ ", list=" + list + "]";
	}
	
}
