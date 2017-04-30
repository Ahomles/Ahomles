package com.cn.javaFrame.common.util.newInstance.Test;


import java.util.HashMap;
import java.util.Map;

import com.cn.javaFrame.common.util.newInstance.BuilderFactory;
import com.cn.javaFrame.common.util.newInstance.Call;
import com.cn.javaFrame.common.util.newInstance.Provider;
import com.cn.javaFrame.common.util.newInstance.Service;
import com.cn.javaFrame.common.util.newInstance.ServiceBuilder;
import com.cn.javaFrame.common.util.newInstance.ServiceManager;

public class Test {
	public static void main(String[] args) throws Exception {
		regist();
		//注册获取的一个过程
		Service ser1=ServiceManager.getSerivceInstance();
		ser1.server();
		Service ser2=ServiceManager.newInstance("Provider2");
		ser2.server();
//		Service ser3=ServiceManager.newInstance("Provider3");
		
		
		
		ServiceBuilder serviceBuilder=BuilderFactory.newBuilder(ServiceBuilder.class);
		Map map=new HashMap();
		map.put("name", "znb");
		map.put("userId", 123l);
		Call call=CommonBuilder.setBuilder(map);
		call.call(serviceBuilder);
		System.out.println(serviceBuilder);
		//		BuilderFactory.newBuilder(BuilderFactory.class);
	}
	public static void regist(){
		Provider provider=new ProviderImpl();
		Provider provider2=new ProviderImpl2();
		ServiceManager.registerProvider(provider);
		ServiceManager.registerProvider("Provider2",provider2);
	}
}
