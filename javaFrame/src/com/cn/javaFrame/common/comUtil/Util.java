package com.cn.javaFrame.common.comUtil;

public class Util {
	public static void main(String[] args) {
		
	}
	
	public static Long convertLong(String str,Long defaultValue){
		if(StringUtil.isNotEmpty(str)&&StringUtil.isNumeric(str)){
			return Long.valueOf(str);
		}
		return defaultValue;
	}
}
