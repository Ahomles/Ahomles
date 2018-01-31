package com.cn.javaFrame.common.util1.dbQuery.dao.impl;

import java.util.HashMap;

import com.cn.javaFrame.common.util1.dbQuery.dao.interfaces.IUserDao;
import com.cn.javaFrame.common.util1.dbQuery.value.UserInfo;

public class UserDaoImpl implements IUserDao{

	@Override
	public UserInfo[] getUserInfoByCondition(String cond, HashMap map,
			int startIndex, int endIndex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserInfoCountByCondition(String cond, HashMap map)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void saveUserInfo(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUserInfos(UserInfo[] userInfos) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
