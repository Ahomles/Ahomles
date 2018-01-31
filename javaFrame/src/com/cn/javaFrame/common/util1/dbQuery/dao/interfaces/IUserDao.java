package com.cn.javaFrame.common.util1.dbQuery.dao.interfaces;

import java.util.HashMap;

import com.cn.javaFrame.common.util1.dbQuery.value.UserInfo;

public interface IUserDao {
	//任何查询实体bean都可以变相调用这个
	public UserInfo[] getUserInfoByCondition(String cond,HashMap map,int startIndex,int endIndex) throws Exception;

	//任何查询数量都可以变相调用这个
	public int getUserInfoCountByCondition(String cond,HashMap map) throws Exception;
	
	public void saveUserInfo(UserInfo userInfo) throws Exception;

	public void saveUserInfos(UserInfo[] userInfos) throws Exception;
}
