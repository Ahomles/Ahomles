package com.cn.javaFrame.common.util.dataConvert.util;

public class StringUtils {
	public static boolean isBlank(String str){
		if(null==str||str.isEmpty()){
			return true;
		}
		return false;
	}
	public static boolean isNotBlank(String str){
		if(null!=str||!str.isEmpty()){
			return true;
		}
		return false;
	}
}
