package com.cn.javaFrame.common.util.proxy;

import java.lang.reflect.Method;

public interface IInterceptor {
	/**
	 * 方法后置动作
	 * @param proxy
	 * @param method
	 * @throws Exception
	 */
	public void afterInvoke(Object proxy,Method method) throws Exception;
	/**
	 * 方法前置动作
	 * @param proxy
	 * @param method
	 * @throws Exception
	 */
	public void beforeInvoke(Object proxy,Method method) throws Exception;

	/**
	 * 异常处理
	 * @param proxy
	 * @param method
	 * @throws Exception
	 */
	public void exceptionHandle(Object proxy,Method method) throws Exception;
}
