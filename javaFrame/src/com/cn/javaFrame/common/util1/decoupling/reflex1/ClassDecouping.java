package com.cn.javaFrame.common.util1.decoupling.reflex1;

import java.util.ArrayList;
import java.util.List;

import com.cn.javaFrame.common.util1.decoupling.reflex1.clss.interfaces.IParentSV;

public class ClassDecouping {
	//建造者模式
	public static List<IParentSV> list = new ArrayList<IParentSV>();
	public static void main(String[] args) throws Exception {
		test01(ConfigUtil.childA);
		test01(ConfigUtil.childB);
		test01(ConfigUtil.childC);
		for(int i=0;i<list.size();i++){
			list.get(i).invoke();
		}
	}
	
	//根据类名解耦，相同的接口和方法，策略模式
	private static void test01(String className) throws Exception {
		IParentSV sv=(IParentSV) getObject(className);//组合模式的构想
		list.add(sv);
	}

	//获取一个类的实例,工厂设计模式
	public static Object getObject(String className) throws Exception{
		return Class.forName(className).newInstance();//反射
	}
	
}
