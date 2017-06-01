package com.cn.javaFrame.common.comUtil;

public class StringUtil {
	public static boolean isEmpty(String str){
		if(null==str||str.isEmpty()){
			return true;
		}
		return false;
	}
	public static boolean isNotEmpty(String str){
		if(null!=str&&!str.isEmpty()){
			return true;
		}
		return false;
	}
}
