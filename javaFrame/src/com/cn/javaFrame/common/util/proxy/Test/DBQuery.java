package com.cn.javaFrame.common.util.proxy.Test;


public interface DBQuery{

	public User load(long userId);
	
	public void save(User user);
	
	public void qryByCondition(long user,int state,String name);
}
