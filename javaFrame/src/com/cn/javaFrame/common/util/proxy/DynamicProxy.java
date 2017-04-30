package com.cn.javaFrame.common.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DynamicProxy implements InvocationHandler {

	private List<IInterceptor> interceptors = null;
	private Object obj;

	public DynamicProxy(List<IInterceptor> interceptors, Object obj) {
		this.interceptors = interceptors;
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		List<IInterceptor> filterInterceptors = interceptors;
		if (filterInterceptors == null && filterInterceptors.isEmpty()) {
			return method.invoke(obj, args);
		}
		// 方法前置动作：拦截器
		for (IInterceptor interceptor : filterInterceptors) {
			try {
				interceptor.beforeInvoke(obj, method);
			} catch (Exception e) {
				continue;
			}
		}
		Object rtn = null;
		try {
			rtn = method.invoke(obj, args);
		} catch (InvocationTargetException ex) {//调用异常
			// 异常处理：拦截器
			for (IInterceptor interceptor : filterInterceptors) {
				try {
					interceptor.exceptionHandle(obj, method);
				} catch (Exception e2) {
					continue;
				}
			}
			throw ex;
		} catch (IllegalArgumentException ex) {//参数异常
			throw new Exception(
					"AOP configuration seems to be invalid: tried calling method ["
							+ method + "] on target [" + obj + "]", ex);
		} catch (IllegalAccessException ex) {//权限异常
			throw new Exception("Could not access method [" + method + "]", ex);
		}
		//后置动作
		for (IInterceptor interceptor : filterInterceptors) {
			try {
				interceptor.afterInvoke(obj, method);
			} catch (Exception e2) {
				continue;
			}
		}
		return rtn;
	}

}
