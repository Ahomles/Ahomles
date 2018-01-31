package com.cn.javaFrame.common.util1.decoupling.reflex1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.cn.javaFrame.common.util1.decoupling.reflex1.clss.impl.ServiceSVImpl;
import com.cn.javaFrame.common.util1.decoupling.reflex1.clss.interfaces.IServiceSV;

public class MethodDecouping {
	public static void main(String[] args) throws Exception {
		test01("test01");
		test01("test02");
		test01("test03");
		test01("test04");
	}
	
	//根据方法去解耦
	public static Map test01(String methodName) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		IServiceSV sv=new ServiceSVImpl();
		Method method=IServiceSV.class.getMethod(methodName, Map.class);
		Map map=(Map)method.invoke(sv, new HashMap());
		return map;
	}
}
