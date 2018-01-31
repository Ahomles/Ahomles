package com.cn.javaFrame.demo.demo01.proxy;

public class ProxyFactory {
	public static String PROXY_TYPE_AOP="aop";
	public static String PROXY_TYPE_SINGLETON="singleton";
	public static String PROXY_TYPE_SRVEJBSTUB="srvejbstub";
	public static String PROXY_TYPE_SERVLET="servlet";
	public static String PROXY_TYPE_SRV_INTERFACE="srv_interface";
	protected static String S_PROXY = "_AIProxy";
	protected static final ProxyClassLoader loader=new ProxyClassLoader();
	public ProxyFactory() {
	}
	
	
}
