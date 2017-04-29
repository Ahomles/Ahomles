package com.cn.javaFrame.common.util.proxy;

import java.lang.reflect.Proxy;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DynamicProxyFactory {
		/**
		 * ��̬������
		 * @param obj
		 * @param interceptors
		 * @return
		 */
		//��̬������
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static <T> T getProxyInstance(T obj ,List<IInterceptor> interceptors){
			DynamicProxy handler=new DynamicProxy(interceptors,obj);
			Class clazz=obj.getClass();	
			Set<Class<?>> interfacesSet=getAllInterfacesForClassAsSet(clazz);
			return (T) Proxy.newProxyInstance(clazz.getClassLoader(), interfacesSet.toArray(new Class<?>[0]), handler);
		}
	
		/**
		 * ��ȡ�������ʵ�ֵ����ýӿ�
		 * @param clazz
		 * @return
		 */
		public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz){
			Set<Class<?>> interfaces=new LinkedHashSet<Class<?>>();
			while(clazz!=null){
				Class<?>[] ifcs=clazz.getInterfaces();
				for(Class<?> ifc:ifcs){
					interfaces.add(ifc);
				}
				clazz=clazz.getSuperclass();
			}
			return interfaces;
		}
}
