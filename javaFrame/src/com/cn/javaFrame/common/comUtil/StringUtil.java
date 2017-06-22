package com.cn.javaFrame.common.comUtil;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if (null == str || str.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String str) {
		if (null != str && !str.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String str) {
		if (str == null)
			return false;
		int sz = str.length();
		for (int i = 0; i < sz; i++)
			if (!Character.isDigit(str.charAt(i)))
				return false;

		return true;
	}
	
	public static Long convertLong(String str,Long defaultValue){
		if(StringUtil.isNotEmpty(str)&&StringUtil.isNumeric(str)){
			return Long.valueOf(str);
		}
		return defaultValue;
	}
	public static Long convert(String str,Long defaultValue){
		if(StringUtil.isNotEmpty(str)&&StringUtil.isNumeric(str)){
			return Long.valueOf(str);
		}
		return defaultValue;
	}
	public static Integer convert(String str,Integer defaultValue){
		if(StringUtil.isNotEmpty(str)&&StringUtil.isNumeric(str)){
			return Integer.valueOf(str);
		}
		return defaultValue;
	}
}
