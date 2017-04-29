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
		if (filterInterceptors != null && !filterInterceptors.isEmpty()) {
			return method.invoke(obj, args);
		}
		// ����ǰ�ö�����������
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
		} catch (InvocationTargetException ex) {//�����쳣
			// �쳣����������
			for (IInterceptor interceptor : filterInterceptors) {
				try {
					interceptor.exceptionHandle(obj, method);
				} catch (Exception e2) {
					continue;
				}
			}
			throw ex;
		} catch (IllegalArgumentException ex) {//�����쳣
			throw new Exception(
					"AOP configuration seems to be invalid: tried calling method ["
							+ method + "] on target [" + obj + "]", ex);
		} catch (IllegalAccessException ex) {//Ȩ���쳣
			throw new Exception("Could not access method [" + method + "]", ex);
		}
		//���ö���
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
