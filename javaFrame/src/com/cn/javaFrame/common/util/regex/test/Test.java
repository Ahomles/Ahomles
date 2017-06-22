package com.cn.javaFrame.common.util.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
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
