package com.cn.javaFrame.common.util.proxy;

import java.lang.reflect.Method;

public interface IInterceptor {
	/**
	 * �������ö���
	 * @param proxy
	 * @param method
	 * @throws Exception
	 */
	public void afterInvoke(Object proxy,Method method) throws Exception;
	/**
	 * ����ǰ�ö���
	 * @param proxy
	 * @param method
	 * @throws Exception
	 */
	public void beforeInvoke(Object proxy,Method method) throws Exception;

	/**
	 * �쳣����
	 * @param proxy
	 * @param method
	 * @throws Exception
	 */
	public void exceptionHandle(Object proxy,Method method) throws Exception;
}
