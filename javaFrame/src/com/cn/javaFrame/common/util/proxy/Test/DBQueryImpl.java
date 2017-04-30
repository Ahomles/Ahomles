package com.cn.javaFrame.common.util.proxy.Test;

import java.io.Serializable;

public class DBQueryImpl implements DBQuery{

	public User load(long userId){
		System.out.println("根据Id查询数据！");
		User user=new User();
		user.setUserId(userId);
		user.setName("znb");
		user.setState(1);
		return user;
	}
	
	public void save(User user){
		System.out.println("保存数据！");
	}
	
	public void qryByCondition(long user,int state,String name){
		System.out.println("根据条件查询数据！");
	}
	
	
}
