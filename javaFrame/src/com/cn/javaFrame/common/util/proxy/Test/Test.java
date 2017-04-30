package com.cn.javaFrame.common.util.proxy.Test;

import java.util.ArrayList;
import java.util.List;

import com.cn.javaFrame.common.util.proxy.DynamicProxyFactory;
import com.cn.javaFrame.common.util.proxy.IInterceptor;

public class Test {
	public static void main(String[] args) {
		List<IInterceptor>  interceptors=new ArrayList<IInterceptor>();
		IInterceptor interceptor=new InterceptorImpl();
		IInterceptor interceptor2=new InterceptorImpl2();
		interceptors.add(interceptor);
		interceptors.add(interceptor2);
		DBQuery dbQry=new DBQueryImpl();
		DBQuery userProxy=(DBQuery)DynamicProxyFactory.getProxyInstance(dbQry,interceptors);
		User user=userProxy.load(123l);
		System.out.println(user);
	}
}
