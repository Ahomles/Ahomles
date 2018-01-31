package com.cn.javaFrame.common.util.regex.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static void test01(){
		String str="";
		String regx = "";
	}
	public static void test02(){
		String strContent=new StringBuffer().append("afasdfadfa NAME_NAME rqwerqerq")
				.append("afdasdfagafda NAME_NAME afsdfasdfasd")
				.append("afdasdfagafda AGGE_AGE afsdfasdfasd")
				.append("afdasdfagafda COUNT_A_BBB afsdfasdfasd")
				.append("afdasdfagafda COUNT_C_BBC afsdfasdfasd").toString();
		String regx = "(COUNT)([_AC_]{3}(B{2,3}))";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(strContent);
		int count=0;//匹配的个数
		int count2=m.groupCount();//说的是捕获组()一个括号一个捕获组
		System.out.println(count2);
		while(m.find()) {
			String rtnStr = m.group();
			System.out.println(rtnStr);
			count++;
		}
		System.out.println(count);
	}
	//字符串替换
	public static void replace(){
		String strContent=new StringBuffer().append("afasdfadfa NAME_NAME rqwerqerq").append("\n")
				.append("afdasdfagafda NAME_NAME afsdfasdfasd").append("\n")
				.append("afdasdfagafda AGGE_AGE afsdfasdfasd").append("\n")
				.append("afdasdfagafda COUNT_A_BB afsdfasdfasd").append("\n")
				.append("afdasdfagafda COUNT_C_BB afsdfasdfasd").toString();
		System.out.println(strContent);
		String regex = "COUNT[_AC_]{3}BB";
		String regexName = "NAME_NAME";
		String regexage = "AGGE_AGE";
		System.out.println("============");
		strContent=strContent.replaceAll(regexage, "26");
		strContent=strContent.replaceAll(regexName, "znb");
		strContent=strContent.replaceAll(regex, "4");
		System.out.println(strContent);
		
	}
	public static void main(String[] args) {
		test02();
//		replace();
	}

}
