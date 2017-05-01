package com.cn.javaFrame.common.util.proxy.Test;

import java.lang.reflect.Method;

import com.cn.javaFrame.common.util.proxy.IInterceptor;

public class InterceptorImpl implements IInterceptor{

	@Override
	public void afterInvoke(Object proxy, Method method) throws Exception {
		System.out.println("===A后置项任务处理！");
	}

	@Override
	public void beforeInvoke(Object proxy, Method method) throws Exception {
		System.out.println("====A前置项任务处理！");
	}

	@Override
	public void exceptionHandle(Object proxy, Method method) throws Exception {
		System.out.println("====A异常任务处理！");
	}

}
