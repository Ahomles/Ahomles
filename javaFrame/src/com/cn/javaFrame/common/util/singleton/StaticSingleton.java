package com.cn.javaFrame.common.util.singleton;

public class StaticSingleton {
	private StaticSingleton(){
		System.out.println("StaticSingleton is create");
	}
	/**
	 * 1》使用内部类来维护单例的实例
	 * >实现延迟加载，当调用getInstance时加载SingletonHolder类
	 * >适用多线程，不用加同步关键字
	 * >序列化和反序列化可能会破坏单例，一般不是对单例序列化，有则注意
	 * @author zhunb3
	 *
	 */
	private static class SingletonHolder{
		private static StaticSingleton instance=new StaticSingleton();
	}
	
	public static StaticSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}
