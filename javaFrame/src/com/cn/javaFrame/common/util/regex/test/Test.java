package com.cn.javaFrame.common.util.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer sb=FileUtil.readFile(FileUtil.path()+"ok.txt");
		Pattern p=Pattern.compile("(?<=public\\s)[\\s\\w]{1,50}");
		Matcher m=p.matcher(sb.toString());
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	
	
	public void getMethodName(String[] args) {
		StringBuffer sb=FileUtil.readFile(FileUtil.path()+"ok.txt");
		Pattern p=Pattern.compile("(?<=public\\s)[\\s\\w]{1,50}");
		Matcher m=p.matcher(sb.toString());
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	
	public void test01(){
		Pattern p=Pattern.compile("(?<=:)\\d+");
		String str="RSQ002:1;RSQ005:2;RSQ006:3";
		Matcher m=p.matcher(str);
		boolean flag=p.matches("(?<=:)\\d+", str);
		while(m.find()){
			System.out.println(m.group());
			System.out.println(flag);
		}
	}
}
