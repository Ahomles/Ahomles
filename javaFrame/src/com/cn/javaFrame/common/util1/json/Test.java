package com.cn.javaFrame.common.util1.json;

import java.util.HashMap;
import java.util.Map;

import com.cn.javaFrame.common.util1.json.gson.JSONUtils;

public class Test {
	public static void main(String[] args) {
		Person[] p=new Person[1];
		p[0]=new Person();
		p[0].setAge("2");
		p[0].setName("znb");
		System.out.println(JSONUtils.obj2JSon(p));
	}
}
